package programmer.lp.resume.servlet;

import programmer.lp.resume.base.BaseServlet;
import programmer.lp.resume.service.AwardService;
import programmer.lp.resume.service.impl.AwardServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/award/*")
public class AwardServlet extends BaseServlet {

    private final AwardService service = new AwardServiceImpl();

    public void admin(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("awards", service.list());
            req.getRequestDispatcher("../WEB-INF/admin/award.jsp").forward(req, resp);
        } catch (Exception e) {
            forwardError(e, req, resp);
        }
    }

    public void save(HttpServletRequest req, HttpServletResponse resp) {
        try {


//            ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
//            upload.setHeaderEncoding("UTF-8");
// 一个FileItem就代表一个请求参数（不要受名字影响，FileItem既包含文件参数，也包含非文件参数）
//            final List<FileItem> fileItems = upload.parseRequest(req);
//            for (FileItem item : fileItems) {
//                System.out.println(item.getName()); // 上传的文件名
//                System.out.println(item.getFieldName()); // 请求参数名
//                System.out.println(item.getString("UTF-8")); // 非文件参数的值
//
//                String fieldName = item.getFieldName();
//                if (item.isFormField()) { // 非文件
//                    System.out.println("fieldName : " + fieldName + " ; " + "parameter : " + item.getString("UTF-8"));
//                } else { // 文件
//                    System.out.println("fieldName : " + fieldName + " ; " + "fileName : " + item.getName());
//
//
//                    try (
//                            BufferedInputStream bis = new BufferedInputStream(item.getInputStream());
//                            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("D:/aaa.jpg")))
//                    ) {
//
//                        final byte[] buff = new byte[4096];
//                        int len;
//                        while ((len = bis.read(buff)) != -1) {
//                            bos.write(buff, 0, len);
//                        }
//
//                    }
//
//                }
//
//            }


//            Award award = new Award();
//            BeanUtils.populate(award, req.getParameterMap());
//            if (service.save(award)) {
//                resp.sendRedirect(req.getContextPath() + "/award/admin");
//            } else {
//                forwardError("获奖信息保存失败", req, resp);
//            }



        } catch (Exception e) {
            forwardError(e, req, resp);
        }
    }

    public void remove(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (service.removeAll(intIds(req.getParameterValues("id")))) {
                resp.sendRedirect(req.getContextPath() + "/award/admin");
            } else {
                forwardError("获奖信息删除失败", req, resp);
            }
        } catch (Exception e) {
            forwardError(e, req, resp);
        }
    }

}
