package programmer.lp.resume.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html;charset=utf-8");
            req.setCharacterEncoding("utf-8");
            String[] split = req.getRequestURI().split("/");
            String methodName = split[split.length - 1];
            Method method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            resp.sendRedirect(req.getContextPath() + "/static/error.jsp");
        }
    }

    public void forwardError(String error, HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("error", error);
            req.getRequestDispatcher("../static/error.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
