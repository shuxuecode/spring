package demo_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by ZSX on 2018/2/7.
 *
 * @author ZSX
 */
public class Response {

    private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream output;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()) {
                System.out.println(file.getAbsolutePath());
                fis = new FileInputStream(file);
                int available = fis.available();
//              todo 需要加头部
                String errorMessage = "HTTP/1.1 200 SUCCESS\r\n"
                        + "Content-Type: text/html\r\n"
                        + "Content-Length: " + available + "\r\n" + "\r\n";
                output.write(errorMessage.getBytes());

                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                System.out.println(ch);
                while (ch != -1) {
                    output.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                    System.out.println(ch);
                }
                output.flush();
                output.close();
            } else {

                String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
                        + "Content-Type: text/html\r\n"
                        + "Content-Length: 23\r\n" + "\r\n"
                        + "<h1>File Not Found</h1>";
                output.write(errorMessage.getBytes());
            }
        } catch (Exception e) {

            System.out.println(e.toString());
        } finally {
            if (fis != null)
                fis.close();
        }
    }
}
