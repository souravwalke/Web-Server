package SingleThreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void run() {
        int port = 8010;
        try (ServerSocket socket = new ServerSocket(port)) {
            socket.setSoTimeout(10000); // Optional: Limits how long the server waits for a connection.

            while (true) {
                try {
                    System.out.println("Server is listening on port " + port);
                    Socket acceptedConnection = socket.accept();
                    System.out
                            .println("Connection accepted from Client " + acceptedConnection.getRemoteSocketAddress());

                    // Using try-with-resources to ensure streams are closed properly
                    try (PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream())) {
                        BufferedReader fromClient = new BufferedReader(
                                new InputStreamReader(acceptedConnection.getInputStream()));
                        toClient.println("Hello from the Server!"); // Send message to the client
                        toClient.flush(); // Send message to the client
                        toClient.close();
                        fromClient.close();
                        acceptedConnection.close();
                    }
                } catch (IOException e) {
                    System.err.println("Error handling client connection: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to start server on port " + port + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }

}