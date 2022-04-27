package programmer.lp.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;

@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/demo3")
    @ResponseBody
    public String demo3(HttpServletRequest request,
                        String username,
                        MultipartFile[] photos) throws Exception {
        System.out.println(username);
        for (MultipartFile photo : photos) {
            String fileName = "upload/image/" + photo.getOriginalFilename();
            String realPath = request.getServletContext().getRealPath(fileName);
            File file = new File(realPath);
            photo.transferTo(file);
        }
        return "upload success!";
    }

    @RequestMapping("/demo2")
    @ResponseBody
    public String demo2(HttpServletRequest request,
                        String username,
                        MultipartFile photo1,
                        MultipartFile photo2) throws Exception {
        System.out.println(username);

        String fileName = "upload/image/" + photo1.getOriginalFilename();
        String realPath = request.getServletContext().getRealPath(fileName);
        File file = new File(realPath);
        photo1.transferTo(file);

        fileName = "upload/image/" + photo2.getOriginalFilename();
        realPath = request.getServletContext().getRealPath(fileName);
        file = new File(realPath);
        photo2.transferTo(file);
        return "upload success!";
    }

    @RequestMapping("/demo1")
    @ResponseBody
    public String demo1(HttpServletRequest request, String username, MultipartFile photo) throws Exception {
        System.out.println(username);
        String fileName = "upload/image/" + photo.getOriginalFilename();
        String realPath = request.getServletContext().getRealPath(fileName);
        File file = new File(realPath);
        photo.transferTo(file);
        System.out.println(file.getAbsolutePath());
        return "upload success!";
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws Exception {
        // 把文件以附件的形式返回

        // 设置响应头
//        response.setHeader("Content-Disposition", "attachment; filename=test.txt");
        response.setHeader("Content-Disposition", "attachment; filename=xiaolu.jpg");

        // 读取文件
//        try (InputStream is = new ClassPathResource("static/test.txt").getInputStream()) {
        try (InputStream is = new ClassPathResource("static/xiaolu.jpg").getInputStream()) {
            // 将文件数据利用response写回到客户端
            IOUtils.copy(is, response.getOutputStream());
        }
    }
}
