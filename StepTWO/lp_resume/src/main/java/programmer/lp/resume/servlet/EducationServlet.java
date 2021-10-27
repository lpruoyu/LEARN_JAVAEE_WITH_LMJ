package programmer.lp.resume.servlet;

import org.apache.commons.beanutils.BeanUtils;
import programmer.lp.resume.bean.Education;
import programmer.lp.resume.dao.EducationDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/education/*")
public class EducationServlet extends BaseServlet {

    private EducationDao dao = new EducationDao();

    public void admin(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("educations", dao.list());
            req.getRequestDispatcher("../static/admin/education.jsp").forward(req, resp);
        } catch (Exception e) {
            forwardError("教育信息获取失败", req, resp);
        }
    }

    public void save(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Education education = new Education();
            BeanUtils.populate(education, req.getParameterMap());
            if (dao.save(education)) {
                resp.sendRedirect(req.getContextPath() + "/education/admin");
            } else {
                forwardError("教育信息保存失败", req, resp);
            }
        } catch (Exception e) {
            forwardError("教育信息保存失败", req, resp);
        }
    }

// removeAll -> remove
    public void remove(HttpServletRequest req, HttpServletResponse resp) {
        try {
            final String[] ids = req.getParameterValues("id");
            if (dao.removeAll(ids)) {
                resp.sendRedirect(req.getContextPath() + "/education/admin");
            } else {
                forwardError("教育信息删除失败", req, resp);
            }
        } catch (Exception e) {
            forwardError("教育信息删除失败", req, resp);
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
