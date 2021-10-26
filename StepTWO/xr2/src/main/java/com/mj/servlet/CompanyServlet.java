package com.mj.servlet;

import com.mj.bean.Company;
import com.mj.beans.util.Beans;
import com.mj.service.CompanyService;
import com.mj.service.impl.CompanyServiceImpl;
import com.mj.util.Uploads;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/company/*")
public class CompanyServlet extends BaseServlet {
    private static final CompanyService service = new CompanyServiceImpl();

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Map<String, Object> params = Uploads.getParams(request);
        Company company = Beans.convert(params, Company.class);
        company.setLogo(Uploads.uploadImage((FileItem) params.get("logoFile"), request, company.getLogo()));
        if (service.save(company)) {
            redirect( "company/admin", request, response);
        } else {
            forwardError("保存公司信息失败", request, response);
        }
    }

    public void admin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setAttribute("companies", service.find());
        request.setAttribute("menu", "company");
        forward("admin/company.jsp", request, response);
    }

    public void remove(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String[] id = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String i : id) {
            ids.add(Integer.valueOf(i));
        }
        if (service.remove(ids)) {
            redirect("company/admin", request, response);
        } else {
            forwardError("删除公司信息失败", request, response);
        }
    }
}
