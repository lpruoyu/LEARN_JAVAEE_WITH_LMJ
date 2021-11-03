package programmer.lp.resume.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public final class Uploads {

    private static final String BASE_DIR = "upload";
    private static final String IMAGE_DIR = "image";

    public static String uploadImage(HttpServletRequest req, FileItem item) throws Exception {
        // 是文件参数 用户也不一定上传了文件
        // 未上传文件的话，item.getName()为空字符串
        // 表单中的属性用户不填时返回值都为空字符串
        final String paramFileName = item.getName();

        if (null == paramFileName || "".equals(paramFileName)) {
            return null;   // 用户未选择文件，就不应该执行保存操作
        }

        // 也可以这样判断：item.getInputStream().available() <= 0
        // 安全起见，双重判断
        if (item.getInputStream().available() <= 0) {
            return null;
        }

        final String localRelativeDirStr = BASE_DIR + "/" + IMAGE_DIR + "/";
        final String localFileDir = req.getServletContext().getRealPath(localRelativeDirStr);
        final String localFileName = UUID.randomUUID() + "." + FilenameUtils.getExtension(paramFileName);

        FileUtils.copyInputStreamToFile(item.getInputStream(), new File(localFileDir, localFileName));

        return localRelativeDirStr + localFileName;
    }

    public static void removeImage(String name, String localFileBasePath) {
        try {
            FileUtils.forceDelete(new File(localFileBasePath, name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeImage(String name, ServletContext context) {
        final String localFileDir = context.getRealPath("/");
        try {
            FileUtils.forceDelete(new File(localFileDir, name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
