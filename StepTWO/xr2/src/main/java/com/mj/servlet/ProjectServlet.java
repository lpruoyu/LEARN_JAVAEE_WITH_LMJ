package com.mj.servlet;

import com.mj.bean.Project;
import com.mj.beans.util.Beans;
import com.mj.service.CompanyService;
import com.mj.service.ProjectService;
import com.mj.service.impl.CompanyServiceImpl;
import com.mj.service.impl.ProjectServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/project/*")
public class ProjectServlet extends BaseServlet {
    private static final ProjectService service = new ProjectServiceImpl();
    private static final CompanyService companyService = new CompanyServiceImpl();

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Project project = Beans.convert(request.getParameterMap(), Project.class);
        if (service.save(project)) {
            redirect( "project/admin", request, response);
        } else {
            forwardError("保存项目经验失败", request, response);
        }
    }

    public void admin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setAttribute("projects", service.find());
        request.setAttribute("menu", "project");
        request.setAttribute("companies", companyService.find());
        forward("admin/project.jsp", request, response);
    }

    public void front(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setAttribute("projects", service.find());
        forward("front/project.jsp", request, response);
    }

    public void remove(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String[] id = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String i : id) {
            ids.add(Integer.valueOf(i));
        }
        if (service.remove(ids)) {
            redirect("project/admin", request, response);
        } else {
            forwardError("删除项目经验失败", request, response);
        }
    }
}
