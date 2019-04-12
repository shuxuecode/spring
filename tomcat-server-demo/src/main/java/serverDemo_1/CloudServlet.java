package serverDemo_1;

/**
 * HttpServlet的具体实现类。
 * Created by ZSX on 2018/2/8.
 *
 * @author ZSX
 */
public class CloudServlet implements HttpServlet {
    @Override
    public String doGet() {
        return this.doPost();
    }

    @Override
    public String doPost() {
        return "<h1>Chicago at Cloud!!!</h1>";
    }
}
