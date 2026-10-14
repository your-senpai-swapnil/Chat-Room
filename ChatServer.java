import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Chat Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());
                
                // Wrap the raw byte stream in a reader that handles text lines
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                
                // Read the message
                String clientMessage = reader.readLine();
                System.out.println("Client says: " + clientMessage);
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}