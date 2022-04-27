package programmer.lp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPSender {
    public static void main(String[] args) throws Exception {
        DatagramSocket sender = new DatagramSocket();
        final byte[] data = "你好呀！".getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet =
                new DatagramPacket
                        (data, 0, data.length,
                                InetAddress.getByName("localhost"), 8888);
        sender.send(packet);
        sender.close();
    }
}
