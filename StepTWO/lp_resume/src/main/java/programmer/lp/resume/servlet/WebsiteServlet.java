package programmer.lp.resume.servlet;

import org.apache.commons.beanutils.BeanUtils;
import programmer.lp.resume.bean.Website;
import programmer.lp.resume.dao.WebsiteDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/website/*")
public class WebsiteServlet extends BaseServlet {

    private WebsiteDao dao = new WebsiteDao();

    public void admin(HttpServletRequest req, HttpServletResponse resp) {
        try {
            final List<Website> websites = dao.list();
            Website website = null;
            if (null != websites && !websites.isEmpty()) {
                website = websites.get(0);
            }
            req.setAttribute("website", website);
            req.getRequestDispatcher("../static/admin/website.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Website website = new Website();
            BeanUtils.populate(website, req.getParameterMap());

            if (dao.save(website)) {
                resp.sendRedirect(req.getContextPath() + "/website/admin");
            } else {
                forwardError("网站信息保存失败", req, resp);
            }

//            if (null == website.getId()) { // 插入
//                //TODO 如果用户直接在浏览器输入save的话，此时id为null，也会插入一条数据，如何解决？
//                if (dao.insert(website)) { // 成功
//                    resp.sendRedirect(req.getContextPath() + "/website/admin");
//                } else { // 失败
//                    forwardError("数据保存失败", req, resp);
//                }
//            } else { // 更新
//                if (dao.update(website)) { // 成功
//                    resp.sendRedirect(req.getContextPath() + "/website/admin");
//                } else { // 失败
//                    forwardError("数据保存失败", req, resp);
//                }
//            }

            // 解决方法：直接更新数据（在用户注册时就插入该数据）
//            if (dao.update(website)) { // 成功
//                resp.sendRedirect(req.getContextPath() + "/website/admin");
//            } else { // 失败
//                forwardError("数据保存失败", req, resp);
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
