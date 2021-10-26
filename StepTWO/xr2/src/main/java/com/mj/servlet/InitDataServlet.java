package com.mj.servlet;

import com.mj.bean.Project;
import com.mj.bean.User;
import com.mj.service.ProjectService;
import com.mj.service.UserService;
import com.mj.service.impl.ProjectServiceImpl;
import com.mj.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/init")
public class InitDataServlet extends HttpServlet {
    private final ProjectService projectService = new ProjectServiceImpl();
    private final UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Project project = projectService.find(3);
        User user = userService.find(1);
        System.out.println(project);
    }
}
