package coder.lp.engit_springjdbc.servlet;

import coder.lp.engit_springjdbc.bean.Customer;
import coder.lp.engit_springjdbc.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/customer/*")
public class CustomerServlet extends HttpServlet {

    private CustomerDao customerDao;

    @Override
    public void init() {
        customerDao = new CustomerDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String[] split = request.getRequestURI().split("/");
        final String methodName = split[split.length - 1];
        Method method;
        try {
            switch (methodName) {
                case "list":
                case "save":
                    method = CustomerServlet.class.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
                    method.invoke(this, request, response);
                    break;

                default:
                    method = CustomerServlet.class.getMethod("error", String.class, HttpServletRequest.class, HttpServletResponse.class);
                    method.invoke(this, "请求页面不存在", request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void list(HttpServletRequest request, HttpServletResponse response) {
        final List<Customer> list = customerDao.list();
        request.setAttribute("customerSize", list.size());
        request.setAttribute("customers", list);
        try {
            request.getRequestDispatcher("../pages/list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");

            String customerName = request.getParameter("customer_name");
            String customerAge = request.getParameter("customer_age");
            String customerHeight = request.getParameter("customer_height");

            if (
                    customerName != null && customerAge != null && customerHeight != null &&
                            !"".equals(customerName) && !"".equals(customerAge) && !"".equals(customerHeight)
            ) {
                if (customerDao.save(new Customer(
                        customerName, Integer.valueOf(customerAge), Double.valueOf(customerHeight)
                ))) {
                    response.sendRedirect("/seven_again/customer/list");
                } else {
                    error("数据保存失败", request, response);
                }
            }else {
                error("用户输入非法值", request, response);
            }
        } catch (Exception e) {
            error("用户输入非法值", request, response);
            e.printStackTrace();
        }
    }

    public void error(String error, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("error", error);
            request.getRequestDispatcher("../pages/error.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}