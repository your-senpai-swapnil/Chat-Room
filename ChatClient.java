import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
    public static void main(String[] args) {
        // 127.0.0.1 is the loopback address (localhost) targeting your own machine
        String hostname = "127.0.0.1";
        int port = 8080;

        try (Socket socket = new Socket(hostname, port)) {
                System.out.println("Successfully connected to the chat server at "
                    + socket.getRemoteSocketAddress() + "!");
            
            // Next step: We will use Input/Output streams here to send messages
            
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}