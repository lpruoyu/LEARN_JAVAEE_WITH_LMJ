package programmer.lp.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/b/b_servlet")
public class BServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("b_servlet");

        // 浏览器路径：http://localhost:8080/demo_02/b/b_servlet

        // 转发测试
        // 相对路径（不带/）
        // 不带/ 都行不通
//        req.getRequestDispatcher("a.jsp").forward(req, resp); // F
//        req.getRequestDispatcher("b/b.jsp").forward(req, resp); // F
//        req.getRequestDispatcher("c/c/c.jsp").forward(req, resp); // F

        // 当前处于根目录下的b目录下，因此需要跳出b目录
//        req.getRequestDispatcher("../a.jsp").forward(req, resp); // T
//        req.getRequestDispatcher("../b/b.jsp").forward(req, resp); // T
//        req.getRequestDispatcher("../c/c/c.jsp").forward(req, resp); // T

        // 相对路径（带/）（/代表webapp根目录）
        // 带/ 都可以
//        req.getRequestDispatcher("/a.jsp").forward(req, resp); // T
//        req.getRequestDispatcher("/b/b.jsp").forward(req, resp); // T
//        req.getRequestDispatcher("/c/c/c.jsp").forward(req, resp); // T
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
