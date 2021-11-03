package programmer.lp.resume.servlet;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import programmer.lp.resume.base.BaseServlet;
import programmer.lp.resume.bean.Company;
import programmer.lp.resume.service.CompanyService;
import programmer.lp.resume.service.impl.CompanyServiceImpl;
import programmer.lp.resume.util.Uploads;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/company/*")
public class CompanyServlet extends BaseServlet<Company> {

    private final CompanyService service = new CompanyServiceImpl();

    public void admin(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("companies", service.list());
            forward(req, resp, "admin/company.jsp");
        } catch (Exception e) {
            forwardError(e, req, resp);
        }
    }

    public void save(HttpServletRequest req, HttpServletResponse resp) {

        try {

            String finalImage = null;
            final ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
            upload.setHeaderEncoding("UTF-8");
            final List<FileItem> fileItems = upload.parseRequest(req);
            final Map<String, String> requestParams = new HashMap<>();

            for (FileItem fileItem : fileItems) {
                final String fieldName = fileItem.getFieldName();
                if (fileItem.isFormField()) { // 非文件
                    requestParams.put(fieldName, fileItem.getString("UTF-8"));
                } else { // 文件
                    finalImage = Uploads.uploadImage(req, fileItem);
                }
            }

            Company company = new Company();
            BeanUtils.populate(company, requestParams);

            String oldImage = null;

            if (null != finalImage) {
                oldImage = company.getLogo();
                company.setLogo(finalImage);
            }

            try {
                if (service.save(company)) {
                    redirect(req, resp, "company/admin");
                } else {
                    forwardError("公司信息保存失败", req, resp);
                }
            } catch (Exception e) {
                forwardError(e, req, resp);
                // 保存失败
                if (null != finalImage) {
                    Uploads.removeImage(finalImage, req.getServletContext());
                }
            }

            // 保存成功，删除旧图片
            if (null != oldImage && !"".equals(oldImage)) {
                Uploads.removeImage(oldImage, req.getServletContext());
            }

        } catch (Exception e) {
            forwardError(e, req, resp);
        }
    }

    public void remove(HttpServletRequest req, HttpServletResponse resp) {

        CompanyServiceImpl impl = (CompanyServiceImpl) service;
        impl.setLocalFileBasePath(req.getServletContext().getRealPath(""));

        try {
            if (service.removeAll(intIds(req.getParameterValues("id")))) {
                redirect(req, resp, "company/admin");
            } else {
                forwardError("公司信息删除失败", req, resp);
            }
        } catch (Exception e) {
            forwardError(e, req, resp);
            e.printStackTrace();
        }
    }

}
