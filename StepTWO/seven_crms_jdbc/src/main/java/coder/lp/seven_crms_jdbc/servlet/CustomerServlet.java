package coder.lp.seven_crms_jdbc.servlet;

import coder.lp.seven_crms_jdbc.bean.Customer;
import coder.lp.seven_crms_jdbc.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

// @WebServlet("/list*")，此时服务器处于根目录（/ 对应 webapp目录）
// @WebServlet("/customer/list") 此时服务器处于根目录下的customer目录（/customer 对应 webapp/customer目录）
@WebServlet("/customer/*")

public class CustomerServlet extends HttpServlet {

    private final CustomerDao dao = new CustomerDao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        final String requestURI = req.getRequestURI();
        final String[] split = requestURI.split("/");
        final String methodName = split[split.length - 1];
        try {
            Method method;
            switch (methodName) {
                case "list":
                case "addcustomer":
                    method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
                    method.invoke(this, req, resp);
                    break;
                default:
                    method = getClass().getMethod("error", String.class, HttpServletRequest.class, HttpServletResponse.class);
                    method.invoke(this, "找不到你找的页面", req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//        if (requestURI.endsWith("list")) {
//            list(req, resp);
//        } else if (requestURI.endsWith("addcustomer")) {
//            addCustomer(req, resp);
//        } else {
//            error(req, resp, "请求页面不存在");
//        }
//    }


    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> list = dao.customers();
        req.setAttribute("customers", list);
        req.setAttribute("customerSize", list.size());
        req.getRequestDispatcher("../pages/list.jsp").forward(req, resp);
    }

    public void addcustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        final String customerName = req.getParameter("customer_name");
        final String customerAge = req.getParameter("customer_age");
        final String customerHeight = req.getParameter("customer_height");
        if (
                null != customerName && !"".equals(customerName) &&
                        null != customerAge && !"".equals(customerAge) &&
                        null != customerHeight && !"".equals(customerHeight)
        ) {
            dao.saveCustomer(new Customer(
                    customerName, Integer.valueOf(customerAge), Double.valueOf(customerHeight)
            ));
            resp.sendRedirect("/seven_crms_jdbc/customer/list");
        } else {
            error("用户信息填写错误", req, resp);
        }
    }

    public void error(String error, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("error", error);
        req.getRequestDispatcher("../pages/error.jsp").forward(req, resp);
    }

}
