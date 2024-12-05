import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
  public static void main(String[] args) {
    String serverIP = "127.0.0.1"; // Server IP
    int port = 9876; // Server Port
    try (DatagramSocket clientSocket = new DatagramSocket()) {
      InetAddress serverAddress = InetAddress.getByName(serverIP);

      String message = "Hello, UDP Server!";
      byte[] sendBuffer = message.getBytes();

      DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, port);
      clientSocket.send(sendPacket);
      System.out.println("Message sent to the server: " + message);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
