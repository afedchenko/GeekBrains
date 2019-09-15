import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

            ChatClient client = new ChatClient();
            System.out.println("Клиент запущен! \n");

            new Thread(() -> {
                try {
                    client.readMessageFromServer();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            ).start();

            new Thread(() -> {
                try {
                    client.writeToConsole();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
    }
}


class ChatClient {
    private Socket socket;
    private DataInputStream inClient;
    private DataOutputStream outClient;
    private Scanner consoleMessageFromClient;

    public ChatClient() throws IOException {
        socket = new Socket("localhost",80);
        inClient  = new DataInputStream(socket.getInputStream());
        outClient = new DataOutputStream(socket.getOutputStream());
    }

    void writeToConsole() throws IOException {
        while (true) {
            consoleMessageFromClient = new Scanner(System.in);
            String consoleTextFromClient = consoleMessageFromClient.nextLine();
            if (consoleMessageFromClient != null || !consoleTextFromClient.trim().isEmpty()) {
                sendMessageFromClient(consoleTextFromClient);
            } else System.err.println("Нельзя отправить пустое сообщение");
        }
    }

    void sendMessageFromClient(String msg) throws IOException {
        if (!socket.isClosed()) {
            if (msg.equals("q") || msg.equals("exit")) {
                System.out.println("Соединение закрыто на Клиенте");
                socket.close();
            }
            outClient.writeUTF(msg);
       } else {
            System.out.println("Соединение закрыто");
        }
    }

    void readMessageFromServer() throws IOException {
        while(!socket.isClosed()) {
            String messageFromServer = inClient.readUTF();
            System.out.println("Сервер: " + messageFromServer);
        }
    }
}
