import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketApp {

    public static void main(String[] args) throws IOException {

        int port = 8089;

        while (true) {
            ServerSocket serverSocket = new ServerSocket(port);
            //ждём подключения, когда происходит соединение
            Socket clientSocket = serverSocket.accept();
            // отправлять
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            // получать сообщения
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.printf("New connection accepted. Port %d%n", clientSocket.getPort());

            // ждем клиента
            final String name = in.readLine();
            // отвечаем клиенту
            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            serverSocket.close();
        }


    }
}
