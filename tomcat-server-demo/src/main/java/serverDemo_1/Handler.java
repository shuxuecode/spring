package serverDemo_1;

import java.io.*;
import java.net.Socket;

/**
 * 该类的作用是根据浏览器传过来信息做出相应的处理，
 * 同时实现Runnable接口。
 *
 * @author ZSX
 */
public class Handler implements Runnable {

    private Socket socket;
    private PrintWriter writer;

    public Handler(Socket socket, PrintWriter writer) {
        this.socket = socket;
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String path = "";
            String method = "";

            while (true) {
                String msg = reader.readLine();
                if (null == msg || "".equals(msg.trim())) {
                    break;
                }

                String[] msgs = msg.split(" ");
                if (3 == msgs.length && "HTTP/1.1".equalsIgnoreCase(msgs[2])) {
                    method = msgs[0];
                    path = msgs[1];
                    break;
                }
            }

            if (path.endsWith("ico")) {
                return;
            }

            HttpServlet httpServlet = ServletContainer.getHttpServlet(path);
            String html = "";
            if ("GET".equals(method)) {
                html = httpServlet.doGet();
            } else if ("POST".equals(method)) {
                html = httpServlet.doGet();
            }
            writer.write(html);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
