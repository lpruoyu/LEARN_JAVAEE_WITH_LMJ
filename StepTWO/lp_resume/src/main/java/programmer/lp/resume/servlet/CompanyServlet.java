package programmer.lp.resume.servlet;

import org.apache.commons.beanutils.BeanUtils;
import programmer.lp.resume.base.BaseServlet;
import programmer.lp.resume.bean.Company;
import programmer.lp.resume.service.CompanyService;
import programmer.lp.resume.service.impl.CompanyServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/company/*")
public class CompanyServlet extends BaseServlet {

    private final CompanyService service = new CompanyServiceImpl();

    public void admin(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("companies", service.list());
            req.getRequestDispatcher("../WEB-INF/admin/company.jsp").forward(req, resp);
        } catch (Exception e) {
            forwardError(e, req, resp);
            e.printStackTrace();
        }
    }

    public void save(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Company company = new Company();
            BeanUtils.populate(company, req.getParameterMap());
            if (service.save(company)) {
                resp.sendRedirect(req.getContextPath() + "/company/admin");
            } else {
                forwardError("公司信息保存失败", req, resp);
            }
        } catch (Exception e) {
            forwardError(e, req, resp);
            e.printStackTrace();
        }
    }

    public void remove(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (service.removeAll(intIds(req.getParameterValues("id")))) {
                resp.sendRedirect(req.getContextPath() + "/company/admin");
            } else {
                forwardError("公司信息删除失败", req, resp);
            }
        } catch (Exception e) {
            forwardError(e, req, resp);
            e.printStackTrace();
        }
    }

}
