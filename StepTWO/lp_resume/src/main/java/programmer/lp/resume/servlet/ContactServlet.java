package programmer.lp.resume.servlet;

import org.apache.commons.beanutils.BeanUtils;
import programmer.lp.resume.base.BaseServlet;
import programmer.lp.resume.bean.Contact;
import programmer.lp.resume.service.UserService;
import programmer.lp.resume.service.WebsiteService;
import programmer.lp.resume.service.impl.UserServiceImpl;
import programmer.lp.resume.service.impl.WebsiteServiceImpl;
import programmer.lp.resume.util.Strings;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@WebServlet("/contact/*")
public class ContactServlet extends BaseServlet<Contact> {

    private WebsiteService websiteService = new WebsiteServiceImpl();
    private UserService userService = new UserServiceImpl();

    public void front(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("contacts", service.list());
        req.setAttribute("user", userService.list().get(0));
        req.setAttribute("website", websiteService.list().get(0));
        forward(req, resp, "front/contact.jsp");
    }

    public void admin(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("contacts", service.list());
            forward(req, resp, "admin/contact.jsp");
        } catch (Exception e) {
            forwardError(e, req, resp);
        }
    }

    public void save(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String captchaClient = req.getParameter("captcha");
            if (Strings.isNotNull(captchaClient)) {
                // 将用户输入的验证码转化为小写形式
                captchaClient = captchaClient.toLowerCase();
            }
            if (!captchaClient.equals(req.getSession().getAttribute("captcha"))) {
                forwardError("验证码不正确", req, resp);
                return;
            }

            Contact contact = new Contact();
            BeanUtils.populate(contact, req.getParameterMap());
            contact.setCreatedTime(new Date());
            if (service.save(contact)) {
                forward(req, resp, "front/contact.jsp");
            } else {
                forwardError("contact保存失败", req, resp);
            }
        } catch (Exception e) {
            forwardError(e, req, resp);
        }
    }

    public void remove(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (service.removeAll(intIds(req.getParameterValues("id")))) {
                redirect(req, resp, "Contact/admin");
            } else {
                forwardError("Contact删除失败", req, resp);
            }
        } catch (Exception e) {
            forwardError(e, req, resp);
        }
    }

}
