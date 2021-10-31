package programmer.lp.resume.base;

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
            req.setCharacterEncoding("utf-8");
            String[] split = req.getRequestURI().split("/");
            String methodName = split[split.length - 1];
            Method method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            forwardError(e, req, resp);
        }
    }

    private void forward404(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // 配置好web.xml中的<error-page/>后，在此处随便重定向至一个不存在的页面，最终都会访问配置好的WEB-INF中的404.jsp
            resp.sendRedirect(req.getContextPath() + "/404");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void forwardError(Exception error, HttpServletRequest req, HttpServletResponse resp) {
        try {
            // 找到最根本的异常信息
            while (error.getCause() != null) {
                error = (Exception) error.getCause();
            }
            req.setAttribute("error", error);
//            req.getRequestDispatcher("../WEB-INF/error.jsp").forward(req, resp);
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void forwardError(String error, HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("error", error);
            req.getRequestDispatcher("../WEB-INF/error.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Integer[] intIds(String[] ids) {
        final Integer[] arr = new Integer[ids.length];
        for (int i = 0; i < ids.length; i++) {
            arr[i] = Integer.parseInt(ids[i]);
        }
        return arr;
    }

}
