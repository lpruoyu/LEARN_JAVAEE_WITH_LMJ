package programmer.lp.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

@Controller
public class UploadAndDownloadController {

    @RequestMapping("/menu")
    public ModelAndView menu(HttpServletRequest request) {
        final ModelAndView modelAndView = new ModelAndView();
        final ArrayList<String> list = new ArrayList<>();
        modelAndView.setViewName("main.jsp");
        try {
            final BufferedReader bufferedReader = new BufferedReader(new FileReader(request.getServletContext().getRealPath("/uploads/file.txt")));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line.split(":")[0]);
            }
            modelAndView.addObject("filelist", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping("/download")
    public void downloads(HttpServletResponse response, HttpServletRequest request, String filename) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path, "file.txt");
        //设置下载资源的MIME类型?
        //设置响应头,告诉浏览器下载的资源需要存储到客户端的硬盘中，而不是解析打开。
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.获取要下载的资源的流对象
        //获取文件的绝对路径
        //获取文件的二进制数据
        byte[] bytes = FileUtils.readFileToByteArray(file);
        //2.响应浏览器
        //获取输出流对象
        ServletOutputStream outputStream = response.getOutputStream();
        //响应资源
        outputStream.write(bytes);
    }

    @RequestMapping("/fileup")
    public void fileup(MultipartFile file, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        String filename = file.getContentType();
        String[] split = filename.split("/");
        if (!file.isEmpty()) {
            String realPath = request.getServletContext().getRealPath("/uploads/");
            String newname = UUID.randomUUID().toString().replace("-", "") + "." + split[1];
            file.transferTo(new File(realPath, newname));
            final BufferedWriter writer = new BufferedWriter(new FileWriter(new File(realPath, "file.txt"), true));
            writer.write(newname + ":" + realPath);
            writer.newLine();
            writer.flush();
            writer.close();
        }
        response.sendRedirect(request.getContextPath() + "/menu");
    }

}
