package lesson25;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 7);
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
