package coder.lp.three_crm.servlet;

import coder.lp.three_crm.bean.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

//        resp.getWriter().write("this is three");

//        String username = req.getParameter("username");
//        String userpswd = req.getParameter("userpswd");
//
////        System.out.println("username : " + username + " , userpwd : " + userpswd);
//
//        PrintWriter writer = resp.getWriter();
//        if ("123".equals(username) && "123".equals(userpswd)) {
//            successful(writer);
//        } else {
//            failed(writer);
//        }
    }

    private void successful(PrintWriter writer) {
        writer.write("<h1 style=\"color: blue; border: 2px solid black\">登录成功</h1>\n");
        writer.write(getSuccessfulDataString());
    }

    private String getSuccessfulDataString() {

        final List<Customer> list = getDataList();

        Customer customer;
        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n" +
                "    <thead>\n" +
                "    <th>姓名</th>\n" +
                "    <th>性别</th>\n" +
                "    <th>电话</th>\n" +
                "    </thead>\n" +
                "    <tbody>\n");
        for (int i = 0; i < list.size(); i++) {
            customer = list.get(i);
            sb.append("<tr> <td >");
            sb.append(customer.getName());
            sb.append("</td > <td >");
            sb.append(customer.getSex());
            sb.append("</td > <td >");
            sb.append(customer.getPhone());
            sb.append("</td > </tr>");
        }
        sb.append("    </tbody>\n" +
                "</table>");
        return sb.toString();
    }

    private List<Customer> getDataList() {
        List<Customer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Customer("张三" + i, "1211531125" + i, (((i & 1) == 1)) ? "男" : "女"));
        }
        return list;
    }

    private void failed(PrintWriter writer) {
        writer.write("<h1 style=\"color: red; border: 2px solid black\">登录失败</h1> ");
        writer.write("<a href=\"http://localhost:8080/three_crm/login.html\">返回首页</a>");
    }

}
