import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket socket;

    // The constructor receives the specific connection for this client
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Grab the input stream for THIS specific client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientMessage;
            
            // This loop continuously reads messages from this client.
            // It will block on readLine(), but ONLY on this background thread!
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Client says: " + clientMessage);
            }
        } catch (IOException e) {
            System.out.println("Client disconnected: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Error closing socket: " + e.getMessage());
            }
        }
    }
}