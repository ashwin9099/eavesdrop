import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        int port = 9876; // Port to listen on
        try (DatagramSocket serverSocket = new DatagramSocket(port)) {
            byte[] receiveBuffer = new byte[1024];
            System.out.println("UDP Server is running on port " + port);

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received: " + message);

                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Server shutting down.");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
