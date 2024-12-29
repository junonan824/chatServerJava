import java.io.*;
import java.net.*;

// ChatClient connects to the server, sends messages, and displays received messages.
public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Receive messages
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Send messages
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) { // User input

            System.out.println("Connected to the server...");

            // Thread to handle incoming messages from the server
            new Thread(() -> {
                String serverMessage;
                try {
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println(serverMessage); // Display server messages
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Send user input to the server
            String userMessage;
            while ((userMessage = userInput.readLine()) != null) {
                out.println(userMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}