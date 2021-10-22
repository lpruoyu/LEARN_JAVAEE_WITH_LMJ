package coder.lp.eight_javascript.servlet;


import coder.lp.eight_javascript.bean.Customer;
import coder.lp.eight_javascript.dao.CustomerDao;

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
        request.setCharacterEncoding("utf-8");

        final String[] split = request.getRequestURI().split("/");
        final String methodName = split[split.length - 1];
        try {
            Method method = CustomerServlet.class.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            try {
                Method method = CustomerServlet.class.getMethod("error", String.class, HttpServletRequest.class, HttpServletResponse.class);
                method.invoke(this, "不存在该页面", request, response);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public void list(HttpServletRequest request, HttpServletResponse response) {
        try {
            final List<Customer> list = customerDao.list();
            request.setAttribute("customerSize", list.size());
            request.setAttribute("customers", list);
            request.getRequestDispatcher("../pages/list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(HttpServletRequest request, HttpServletResponse response) {
        try {
            Customer customer = newCustomer(request);
            if (null != customer) {
                if (customer.getId() != null) {
                    // update
                    if (customerDao.update(customer)) {
                        response.sendRedirect("/eight_javascript/customer/list");
                    } else {
                        error("数据更新失败", request, response);
                    }
                } else {
                    // save
                    if (customerDao.save(customer)) {
                        response.sendRedirect("/eight_javascript/customer/list");
                    } else {
                        error("客户添加失败", request, response);
                    }
                }
            } else {
                error("用户非法输入", request, response);
            }
        } catch (Exception e) {
            error("数据保存失败", request, response);
            e.printStackTrace();
        }
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) {
        try {
            String customerId = request.getParameter("id");
            if (customerId != null && !"".equals(customerId)) {
                final Integer id = Integer.valueOf(customerId);
                final Customer customer = customerDao.edit(id);

                try {
                    request.setAttribute("customer", customer);
                    request.getRequestDispatcher("../pages/save.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    error("数据编辑失败", request, response);
                }
            }
        } catch (Exception e) {
            error("数据编辑失败", request, response);
            e.printStackTrace();
        }
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) {
        try {
            String customerId = request.getParameter("id");
            if (customerId != null && !"".equals(customerId)) {
                final Integer id = Integer.valueOf(customerId);
                if (customerDao.remove(id)) {
                    response.sendRedirect("/eight_javascript/customer/list");
                } else {
                    error("数据删除失败", request, response);
                }
            }
        } catch (Exception e) {
            error("数据删除失败", request, response);
            e.printStackTrace();
        }
    }

    private void error(String error, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("error", error);
            request.getRequestDispatcher("../pages/error.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Customer newCustomer(HttpServletRequest request) {
        String customerName = request.getParameter("customer_name");
        String customerAge = request.getParameter("customer_age");
        String customerHeight = request.getParameter("customer_height");
        String customerId = request.getParameter("customer_id");
        if (
                customerName != null && customerAge != null && customerHeight != null &&
                        !"".equals(customerName) && !"".equals(customerAge) && !"".equals(customerHeight)
        ) {
            Customer customer = new Customer(
                    customerName, Integer.valueOf(customerAge), Double.valueOf(customerHeight)
            );
            if (customerId != null && !customerId.equals("")) {
                customer.setId(Integer.valueOf(customerId));
            }
            return customer;
        }
        return null;
    }

}