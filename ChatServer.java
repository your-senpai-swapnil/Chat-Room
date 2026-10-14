import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Chat Server is listening on port " + port);

            while (true) {
                // 1. Wait for a client to connect (Blocks here)
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());
                
                // 2. Hand the client socket off to a new Thread
                ClientHandler clientThread = new ClientHandler(clientSocket);
                clientThread.start(); // This triggers the run() method in the background
                
                // 3. The loop instantly restarts and goes back to waiting at .accept()
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}