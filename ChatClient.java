import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
    public static void main(String[] args) {
        String hostname = "127.0.0.1";
        int port = 8080;

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Successfully connected to the chat server!");
            
            // Grab the socket's output stream
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            
            // Send a text message to the server
            writer.println("Hello Server! This is Joy Boy.");
            
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}