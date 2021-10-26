package coder.lp.two_javaeestart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        outHTML(req, resp);
    }


    private void outHTML(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

//        File file = new File("D:\\code_space\\LearnJava\\IntellijIdea\\LearnJavaEEWithXMGLMJ\\StepTWO\\two_javaeestart\\src\\main\\webapp\\user.html");



    }


//    private void outHTML(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=UTF-8");
//
//        String username = req.getParameter("username");
//        String userpwd = req.getParameter("userpwd");
//
//        System.out.println("username : " + username + " , userpwd : " + userpwd);
//
//        PrintWriter writer = resp.getWriter();
//        if ("123".equals(username) && "123".equals(userpwd)) {
//
//            writer.write("<h1 style=\"color: blue; border: 2px solid black\">这是登录成功之后的user页面。</h1>\n" +
//                    "<ul>\n" +
//                    "    <li>个人信息</li>\n" +
//                    "    <li>修改密码</li>\n" +
//                    "    <li>退出登录</li>\n" +
//                    "</ul>");
//        } else {
//            writer.write("<h1 style=\"color: red; border: 2px solid black\">登录失败</h1> ");
//        }
//
//    }

    private void outPlain(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain;charset=utf-8");

        System.out.println(req.getParameter("userpwd"));
        System.out.println(req.getParameter("username"));

        PrintWriter writer = resp.getWriter();
        writer.write("刘鹏");

        writer.println("");

    }

}