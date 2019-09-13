import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ChatServer serv = new ChatServer();
        serv.start();
        serv.catchClient();

        new Thread(() -> {
            try {
                    serv.readMessageFromUser();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
        ).start();

        new Thread(() -> {
            try {
                serv.writeToConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class ChatServer {
    private DataInputStream inServer;
    private DataOutputStream outServer;
    private ServerSocket server;
    private Socket socket;
    private Scanner consoleMessageFromServer;

    void start() {
        try {
            server = new ServerSocket(80);
        } catch (IOException e) {
            System.out.println("Нет соединения по 80 порту =(");
        }
        System.out.print("Сервер запущен! \n");
    }

    void catchClient() throws IOException {
        try {
            socket = server.accept();
            System.out.println("Клиент с адресом " + socket.getInetAddress() + " подсоединился! \n");
        } catch (IOException e) {
            System.out.println("Нет доступа к ");
        }
        inServer = new DataInputStream(socket.getInputStream());
        outServer = new DataOutputStream(socket.getOutputStream());
    }

    void sendMessageFromServer(String msg) throws IOException {
        if (!socket.isClosed()) {
            if (msg.equals("exit") || msg.equals("q")) {
                System.out.println("Соединение закрыто");
                socket.close();
            }
            outServer.writeUTF(msg);
        } else {
            System.out.println("Соединение закрыто");
        }
    }

    void readMessageFromUser() throws IOException {
        while (!socket.isClosed()) {
            String messageFromUser = inServer.readUTF();
            System.out.println("Пользователь: " + messageFromUser);
        }
    }

    void writeToConsole() throws IOException {
        while (true) {
            consoleMessageFromServer = new Scanner(System.in);
            String consoleText = consoleMessageFromServer.nextLine();
            if (consoleMessageFromServer != null || !consoleText.trim().isEmpty()) {
                sendMessageFromServer(consoleText);
            } else System.err.println("Нельзя отправить пустое сообщение");
        }
    }
}
