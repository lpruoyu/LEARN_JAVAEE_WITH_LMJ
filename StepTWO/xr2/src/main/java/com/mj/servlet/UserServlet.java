package com.mj.servlet;

import com.mj.bean.User;
import com.mj.bean.Website;
import com.mj.beans.util.Beans;
import com.mj.service.AwardService;
import com.mj.service.SkillService;
import com.mj.service.UserService;
import com.mj.service.WebsiteService;
import com.mj.service.impl.AwardServiceImpl;
import com.mj.service.impl.SkillServiceImpl;
import com.mj.service.impl.UserServiceImpl;
import com.mj.service.impl.WebsiteServiceImpl;
import com.mj.util.Uploads;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private final UserService service = new UserServiceImpl();
    private static final WebsiteService websiteService = new WebsiteServiceImpl();
    private static final SkillService skillService = new SkillServiceImpl();
    private static final AwardService awardService = new AwardServiceImpl();

    public void login(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        User user = Beans.convert(request.getParameterMap(), User.class);
        user = service.find(user);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            redirect("user/admin", request, response);
        } else {
            forwardError("用户名或密码错误", request, response);
        }
    }

    public void editPassword(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setAttribute("menu", "password");
        forward("admin/password.jsp", request, response);
    }

    public void updatePassword(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        String originPassword = user.getPassword();
        String oldPassword = request.getParameter("oldPassword");
        if (originPassword.equals(oldPassword)) {
            user.setPassword(request.getParameter("password"));
            if (service.save(user)) {
                logout(request, response);
            } else {
                user.setPassword(originPassword);
                forwardError("更新密码失败", request, response);
            }
        } else {
            forwardError("旧密码错误", request, response);
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.getSession().removeAttribute("user");
        redirect("page/login.jsp", request, response);
    }

    public void admin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        User user = service.find().get(0);
        request.setAttribute("user", user);
        request.setAttribute("menu", "user");
        request.getSession().setAttribute("user", user);
        forward("admin/user.jsp", request, response);
    }

    public void front(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        User user = service.find().get(0);
        request.setAttribute("user", user);
        request.getSession().setAttribute("user", user);

        List<Website> websites = websiteService.find();
        if (websites.size() > 0) {
            request.setAttribute("website", websites.get(0));
        }

        request.setAttribute("skills", skillService.find());

        request.setAttribute("awards", awardService.find());

        forward("front/user.jsp", request, response);
    }

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        User loginUser = (User) request.getSession().getAttribute("user");
        Map<String, Object> params = Uploads.getParams(request);
        User user = Beans.convert(params, User.class);
        user.setPhoto(Uploads.uploadImage((FileItem) params.get("photoFile"), request, user.getPhoto()));
        user.setId(loginUser.getId());
        user.setPassword(loginUser.getPassword());
        user.setEmail(loginUser.getEmail());
        if (service.save(user)) {
            redirect( "user/admin", request, response);
        } else {
            forwardError("保存个人信息失败", request, response);
        }
    }
}
