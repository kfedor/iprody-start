package lesson25;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(7);
             Socket socket = serverSocket.accept();
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {

            read(inputStream, outputStream);

            while (scanner.hasNextLine()) {
                String request = scanner.nextLine();
                outputStream.writeUTF(request);
                if (request.equalsIgnoreCase("stop")) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void read(DataInputStream inputStream, DataOutputStream outputStream) {
        new Thread(() -> {
            try {
                while (true) {
                    String request = inputStream.readUTF();
                    System.out.println(request);
                    if (!request.startsWith("Echo: ")) {
                        outputStream.writeUTF("Echo: " + request);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("Connection lost.", e);
            }
        }).start();
    }
}
