import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Server {

    static final int PORT = 81;

    static final String NEW_CLIENT_NAME = "NEW_CLIENT_NAME";

    private ConcurrentLinkedQueue<ClientHandler> clients
            = new ConcurrentLinkedQueue<>();

    HashMap<String, ClientHandler> clientsMap = new HashMap<>();

    private ConcurrentLinkedQueue<String>  clientNames = new ConcurrentLinkedQueue<>();

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

    public void sendMessageToAllClients(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }

    public void sendMessageToNick(String client, String msg){
        clientsMap.get(client).sendMsg(msg);
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

    public void addClientName(String name, ClientHandler clientHandler){
        clientsMap.put(name, clientHandler);
    }

    public void removeClientName(String name){
        clientsMap.remove(name);
    }



    public static void main(String[] args) {
        new Server();
    }
}
