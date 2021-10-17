package coder.lp.five_crms.servlet;

import coder.lp.five_crms.bean.Customer;
import coder.lp.five_crms.data.DataManage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {

    private static final String JSP_USERLIST = "pages/userlist.jsp";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = DataManage.getCustomers();
        request.setAttribute("customers", customers);
//        有服务器完成操作，只需要告诉相对路径
//        相对至webapp目录下
        request.getRequestDispatcher(JSP_USERLIST).forward(request, response);
    }

}
