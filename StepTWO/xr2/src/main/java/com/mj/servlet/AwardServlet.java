package com.mj.servlet;

import com.mj.bean.Award;
import com.mj.beans.util.Beans;
import com.mj.service.AwardService;
import com.mj.service.impl.AwardServiceImpl;
import com.mj.util.Uploads;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@WebServlet("/award/*")
public class AwardServlet extends BaseServlet {
    private static final AwardService service = new AwardServiceImpl();

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Map<String, Object> params = Uploads.getParams(request);
        Award award = Beans.convert(params, Award.class);
        award.setImage(Uploads.uploadImage((FileItem) params.get("imageFile"), request, award.getImage()));
        if (service.save(award)) {
            redirect( "award/admin", request, response);
        } else {
            forwardError("保存获奖成就失败", request, response);
        }
    }

    public void admin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setAttribute("awards", service.find());
        request.setAttribute("menu", "award");
        forward("admin/award.jsp", request, response);
    }

    public void remove(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String[] id = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String i : id) {
            ids.add(Integer.valueOf(i));
        }
        if (service.remove(ids)) {
            redirect("award/admin", request, response);
        } else {
            forwardError("删除获奖成就失败", request, response);
        }
    }
}
