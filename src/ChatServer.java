import java.io.*;
import java.net.*;
import java.util.*;

// ChatServer manages multiple clients, assigns unique IDs, and broadcasts messages.
public class ChatServer {
    private static int clientId = 0; // Counter for unique user IDs
    private static List<ClientHandler> clients = new ArrayList<>(); // Active client list

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started...");
            while (true) {
                // Accept incoming client connections
                Socket clientSocket = serverSocket.accept();
                clientId++;
                ClientHandler clientHandler = new ClientHandler(clientSocket, "User" + clientId);
                clients.add(clientHandler); // Add new client to the list
                new Thread(clientHandler).start(); // Handle client in a separate thread
                System.out.println("User" + clientId + " connected.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Broadcast messages to all connected clients except the sender
    static void broadcastMessage(String message, String senderId) {
        for (ClientHandler client : clients) {
            if (!client.getUserId().equals(senderId)) {
                client.sendMessage(message);
            }
        }
    }

    // Handles individual client connections
    static class ClientHandler implements Runnable {
        private Socket socket;
        private String userId;
        private PrintWriter out;

        public ClientHandler(Socket socket, String userId) {
            this.socket = socket;
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        // Sends a message to this client
        public void sendMessage(String message) {
            out.println(message);
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Welcome, " + userId + "!");
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(userId + ": " + message);
                    ChatServer.broadcastMessage(userId + ": " + message, userId); // Broadcast to others
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}