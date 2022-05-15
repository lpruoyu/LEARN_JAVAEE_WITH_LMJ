package programmer.lp.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import programmer.lp.properties.ProjectProperties;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

@RestController
//@RequestMapping("/test")
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test successful 中文 !!!!";
    }

    @GetMapping("/date")
    public Date date(Date date) {
        return date;
    }

    @Autowired
    private ProjectProperties projectProperties;

    @PostMapping("/fileUpload")
    public String fileUpload(MultipartFile file) throws Exception {
        final ProjectProperties.Uploads uploads = projectProperties.getUploads();
        final String basePath = uploads.getBasePath();
        final String imagePath = uploads.getImagePath();
        final String fileName = UUID.randomUUID() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
//        final String fileName = file.getOriginalFilename();
        File destFile = new File(basePath + imagePath + fileName);
        // 确保目标文件所在的目录存在
        // destFile.getParentFile().mkdirs();
        FileUtils.forceMkdirParent(destFile);
        file.transferTo(destFile);
        System.out.println(destFile.getAbsolutePath());
        return "success";
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws Exception {
        // 把文件以附件的形式返回

        // 设置响应头
        response.setHeader("Content-Disposition", "attachment; filename=test.txt");

        // 读取文件
        try (InputStream is = new ClassPathResource("static/test.txt").getInputStream()) {
            // 将文件数据利用response写回到客户端
            IOUtils.copy(is, response.getOutputStream());
        }
    }

    @GetMapping("/requestParam")
    public String requestParam(String name) {
        System.out.println(name);
        return name;
    }

}
