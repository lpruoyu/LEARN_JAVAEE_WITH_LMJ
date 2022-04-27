package programmer.lp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver {
    public static void main(String[] args) throws Exception {
        DatagramSocket receiver = new DatagramSocket(8888);
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        receiver.receive(packet);
        System.out.println(new String(bytes, 0, packet.getLength()));
        receiver.close();
    }
}
