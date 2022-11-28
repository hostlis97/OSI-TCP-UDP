import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket(ServerConfig.HOST,ServerConfig.PORT);) {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
            System.out.println("введите ваше имя ");
            Scanner s = new Scanner(System.in);
            String name = s.nextLine();
            writer.println(name);
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
