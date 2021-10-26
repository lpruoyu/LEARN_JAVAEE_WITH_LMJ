package com.mj.servlet;

import com.mj.bean.Education;
import com.mj.beans.util.Beans;
import com.mj.service.EducationService;
import com.mj.service.impl.EducationServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/education/*")
public class EducationServlet extends BaseServlet {
    private static final EducationService service = new EducationServiceImpl();

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Education education = Beans.convert(request.getParameterMap(), Education.class);
        if (service.save(education)) {
            redirect( "education/admin", request, response);
        } else {
            forwardError("保存教育经验失败", request, response);
        }
    }

    public void admin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setAttribute("educations", service.find());
        request.setAttribute("menu", "education");
        forward("admin/education.jsp", request, response);
    }

    public void front(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setAttribute("educations", service.find());
        forward("front/education.jsp", request, response);
    }

    public void remove(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String[] id = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String i : id) {
            ids.add(Integer.valueOf(i));
        }
        if (service.remove(ids)) {
            redirect("education/admin", request, response);
        } else {
            forwardError("删除教育经验失败", request, response);
        }
    }
}
