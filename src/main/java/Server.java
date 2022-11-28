import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(ServerConfig.PORT)) {
            while (true) {
                try (Socket client = server.accept()) {
                    PrintWriter writer = new PrintWriter(client.getOutputStream(),true);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    writer.println("Добро пожаловать на серевр!");
                    String name = reader.readLine();

                    writer.println(String.format("Привет %s, твой порт %d", name, client.getPort()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
