package com.mj.servlet;

import com.mj.bean.Website;
import com.mj.beans.util.Beans;
import com.mj.service.WebsiteService;
import com.mj.service.impl.WebsiteServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/website/*")
public class WebsiteServlet extends BaseServlet {
    private static final WebsiteService service = new WebsiteServiceImpl();

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Website website = Beans.convert(request.getParameterMap(), Website.class);
        if (service.save(website)) {
            redirect( "website/admin", request, response);
        } else {
            forwardError("保存网站信息失败", request, response);
        }
    }

    public void admin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Website> websites = service.find();
        if (websites.size() > 0) {
            request.setAttribute("website", websites.get(0));
        }
        request.setAttribute("menu", "website");
        forward("admin/website.jsp", request, response);
    }
}
