package programmer.lp;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        try (final Socket socket = new Socket("localhost", 8888)) {
            try (
                    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    final OutputStream os = socket.getOutputStream();
                    final InputStream is = socket.getInputStream()
            ) {
                // 给服务器写数据
                os.write("hello, tcp network programming!".getBytes(StandardCharsets.UTF_8));
                // 给服务器的内容都写完之后，要关闭输出
                socket.shutdownOutput();

                // 接收服务器返回的数据
                final byte[] bytes = new byte[10240];
                int len;
                while ((len = is.read(bytes)) != -1) {
                    baos.write(bytes, 0, len);
                }
                baos.flush();
                final byte[] data = baos.toByteArray();
                final String dataStr = new String(data, StandardCharsets.UTF_8);
                System.out.println("客户端接受到服务器返回的数据：" + dataStr);
                socket.shutdownInput();
            }
        }
    }
}
