import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {

    private Server server;
    private PrintWriter out;

    private Scanner in;
    private static final String HOST = "localhost";
    private static final int PORT = 80;
    private static final String PERSONAL_MESSAGE_PREFIX = "/w ";

    private Socket clientSocket = null;

    private static int clients_count = 0;

    private String clientName;

    public ClientHandler(Socket socket, Server server) {
        try {
            clients_count++;
            this.server = server;
            this.clientSocket = socket;
            this.out = new PrintWriter(socket.getOutputStream());
            this.in = new Scanner(socket.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            server.sendMessageToAllClients("Новый участник вошёл в чат!", this);
            server.sendMessageToAllClients("Клиентов в чате = " + clients_count, this);

            while (true) {
                if (in.hasNext()) {
                    String clientMessage = in.nextLine();

                    if (clientMessage.startsWith(Server.NEW_CLIENT_NAME)) {
                        clientName = clientMessage.substring(Server.NEW_CLIENT_NAME.length());
                    } else {
                        if (clientMessage.equalsIgnoreCase("##session##end##")) {
                            break;
                        }
                        if (clientMessage.startsWith(PERSONAL_MESSAGE_PREFIX)) {
                            String mess = clientMessage.substring(PERSONAL_MESSAGE_PREFIX.length());
                            String nick = mess.substring(0, mess.indexOf(" "));
                            mess = mess.substring(mess.indexOf(" ") + 1);
                            server.sendMessageToNick(nick, mess, this);
                        } else {
                            System.out.println(clientMessage);
                            server.sendMessageToAllClients(clientMessage, this);
                        }
                    }
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            this.close();
        }
    }

    // отправляем сообщение
    public void sendMsg(String msg) {
        try {
            out.println(msg);
            out.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // клиент выходит из чата
    public void close() {
        // удаляем клиента из списка
        server.removeClient(this);
        clients_count--;
        server.sendMessageToAllClients("Клиентов в чате = " + clients_count, this);
    }

    public String getClientName() {
        return clientName;
    }
}
