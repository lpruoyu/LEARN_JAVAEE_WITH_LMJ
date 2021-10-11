package coder.lp.two_javaeestart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/path_multi_01", "/path_multi_02", "/path_multi_03"})
public class PathTestServlet extends HttpServlet {

    public PathTestServlet() {
        System.out.println(this + "_构造方法");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(this + "_service 被调用_" + req.getServletPath());
    }

}
