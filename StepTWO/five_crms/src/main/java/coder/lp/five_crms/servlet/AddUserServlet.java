package coder.lp.five_crms.servlet;

import coder.lp.five_crms.bean.Customer;
import coder.lp.five_crms.data.DataManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        DataManage.getCustomers().add(new Customer(
                request.getParameter("username"),
                Integer.valueOf(request.getParameter("userage")),
                Float.valueOf(request.getParameter("usertall"))
        ));

//        由浏览器实现操作，需要告诉context path
        response.sendRedirect("/five_crms/userlist");
        // 第二种方式实现重定向 不推荐使用
//        response.setStatus(302); // 状态码
//        response.setHeader("Location", "/five_crms/userlist"); // 响应头Location

    }
}
