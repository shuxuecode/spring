package serverDemo_1;

/**
 * 为了实现起来简单方便，我自己定义了一个HttpServlet。
 * Created by ZSX on 2018/2/8.
 *
 * @author ZSX
 */
public interface HttpServlet {
    public String doGet();
    public String doPost();
}
