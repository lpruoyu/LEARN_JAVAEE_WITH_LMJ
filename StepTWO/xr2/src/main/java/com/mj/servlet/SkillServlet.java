package com.mj.servlet;

import com.mj.bean.Skill;
import com.mj.beans.util.Beans;
import com.mj.service.SkillService;
import com.mj.service.impl.SkillServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/skill/*")
public class SkillServlet extends BaseServlet {
    private static final SkillService service = new SkillServiceImpl();

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Skill skill = Beans.convert(request.getParameterMap(), Skill.class);
        if (service.save(skill)) {
            redirect( "skill/admin", request, response);
        } else {
            forwardError("保存专业技能失败", request, response);
        }
    }

    public void admin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Skill> skills = service.find();
        request.setAttribute("skills", skills);
        request.setAttribute("menu", "skill");
        forward("admin/skill.jsp", request, response);
    }

    public void remove(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String[] id = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String i : id) {
            ids.add(Integer.valueOf(i));
        }
        if (service.remove(ids)) {
            redirect("skill/admin", request, response);
        } else {
            forwardError("删除专业技能失败", request, response);
        }
    }
}
