package programmer.lp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/a_servlet")
public class AServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("a_servlet");
        // 浏览器路径：http://localhost:8080/demo_02/a.jsp

        // 转发测试
        // 相对路径（不带/）
        // 当前处于根目录（webapp）
//        req.getRequestDispatcher("a.jsp").forward(req, resp); // T
//        req.getRequestDispatcher("b/b.jsp").forward(req, resp); // T
//        req.getRequestDispatcher("c/c/c.jsp").forward(req, resp); // T

        // 相对路径（带/）（/代表webapp根目录）
//        req.getRequestDispatcher("/a.jsp").forward(req, resp); // T
//        req.getRequestDispatcher("/b/b.jsp").forward(req, resp); // T
//        req.getRequestDispatcher("/c/c/c.jsp").forward(req, resp); // T
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
