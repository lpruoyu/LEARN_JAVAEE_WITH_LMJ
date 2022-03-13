package programmer.lp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        try (final ServerSocket server = new ServerSocket(8888)) {
            while (true) {
                final Socket client = server.accept();
                new Thread(() -> {
                    try {
                        doClient(client);
                        client.close();
                    } catch (IOException e) {
                    }
                }).start();
            }
        }
    }

    private static void doClient(Socket client) {
        try (
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                final InputStream is = client.getInputStream();
                final OutputStream os = client.getOutputStream()
        ) {
            // 接收客户端的数据
            final byte[] bytes = new byte[10240];
            int len;
            while ((len = is.read(bytes)) != -1) {
                baos.write(bytes, 0, len);
            }
            baos.flush();
            final byte[] data = baos.toByteArray();
            final String dataStr = new String(data, StandardCharsets.UTF_8);
            final String clientAddr = client.getInetAddress().getHostAddress();
            System.out.println("服务器接受到【" + clientAddr + "】的数据：" + dataStr);
            // 接收完毕客户端发送过来的数据之后，就要关闭输入
            client.shutdownInput();

            // 给客户端响应数据
            os.write("Hi, I am Server. I have accepted your data!".getBytes(StandardCharsets.UTF_8));
            client.shutdownOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
