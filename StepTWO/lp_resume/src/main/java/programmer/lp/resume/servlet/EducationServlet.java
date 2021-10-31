package programmer.lp.resume.servlet;

import org.apache.commons.beanutils.BeanUtils;
import programmer.lp.resume.base.BaseServlet;
import programmer.lp.resume.bean.Education;
import programmer.lp.resume.service.EducationService;
import programmer.lp.resume.service.impl.EducationServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/education/*")
public class EducationServlet extends BaseServlet {

    private final EducationService service = new EducationServiceImpl();

    public void admin(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("educations", service.list());
            req.getRequestDispatcher("../WEB-INF/admin/education.jsp").forward(req, resp);
        } catch (Exception e) {
            forwardError(e, req, resp);
        }
    }

    public void save(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Education education = new Education();
            BeanUtils.populate(education, req.getParameterMap());
            if (service.save(education)) {
                resp.sendRedirect(req.getContextPath() + "/education/admin");
            } else {
                forwardError("教育信息保存失败", req, resp);
            }
        } catch (Exception e) {
            forwardError(e, req, resp);
        }
    }

    // removeAll -> remove
    public void remove(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (service.removeAll(intIds(req.getParameterValues("id")))) {
                resp.sendRedirect(req.getContextPath() + "/education/admin");
            } else {
                forwardError("教育信息删除失败", req, resp);
            }
        } catch (Exception e) {
            forwardError(e, req, resp);
        }
    }

//    public void remove(HttpServletRequest req, HttpServletResponse resp) {
//        try {
//            Integer id = Integer.valueOf(req.getParameter("id"));
//            if (dao.remove(id)) {
//                resp.sendRedirect(req.getContextPath() + "/education/admin");
//            } else {
//                forwardError("教育信息删除失败", req, resp);
//            }
//        } catch (Exception e) {
//            forwardError("教育信息删除失败", req, resp);
//        }
//    }

}
