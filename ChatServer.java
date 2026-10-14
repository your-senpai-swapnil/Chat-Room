import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        int port = 8080;

        // try-with-resources automatically closes the socket if the server crashes
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Chat Server is listening on port " + port);

            // Infinite loop to keep the server alive
            while (true) {
                // .accept() blocks execution until a client knocks on port 8080
                Socket clientSocket = serverSocket.accept();
                
                System.out.println("New client connected: " + clientSocket.getInetAddress());
                
                // Next step: We will hand this clientSocket off to a new Thread here
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}