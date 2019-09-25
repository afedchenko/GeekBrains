import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Server {

    static final int PORT = 80;

    static final String NEW_CLIENT_NAME = "/name ";

    private ConcurrentLinkedQueue<ClientHandler> clients
            = new ConcurrentLinkedQueue<>();

    public Server() {
        Socket clientSocket = null;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");
            while (true) {
                clientSocket = serverSocket.accept();
                ClientHandler client = new ClientHandler(clientSocket, this);
                clients.add(client);
                new Thread(client).start();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (clientSocket != null)
                    clientSocket.close();
                System.out.println("Сервер остановлен");
                if (serverSocket != null)
                    serverSocket.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void showClients(){
        for (ClientHandler cl : clients)
            System.out.println(cl);
    }

    public void sendMessageToAllClients(String msg, ClientHandler handler) {
        for (ClientHandler o : clients) {
            o.sendMsg((handler.getClientName() == null ? "server" : handler.getClientName()) + ": " + msg);
        }
    }

    public void sendMessageToNick(String client, String msg, ClientHandler handler){
        if(handler.getClientName() != null) {

            for (ClientHandler o : clients) {
                if(o.getClientName().equals(client)){
                    o.sendMsg("Personal message from " + handler.getClientName() + ": " + msg);
                }
            }
        }
    }

    public void removeClient(int pos) {
        int p = 0;
        if (pos > clients.size() || pos < 0) return;
        ClientHandler client = null;
        for (ClientHandler c : clients){
            p++;
            if(p == pos){
                client = c;
                break;
            }
        }
        clients.remove(client);
    }

    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }



    public static void main(String[] args) {
        new Server();
    }
}
