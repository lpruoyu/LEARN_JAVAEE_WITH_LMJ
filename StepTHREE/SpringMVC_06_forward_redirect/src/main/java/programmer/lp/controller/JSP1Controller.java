package programmer.lp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class JSP1Controller {
    @Value("${jsp-welcome-localpath}")
    private String welcome;

    @GetMapping("${jsp-welcome-url}")
    public void jsp1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 从数据库中查询到的用户信息
        request.setAttribute("username", "lpruoyu");
        // 转发到欢迎用户的JSP
        request.getRequestDispatcher(welcome).forward(request, response);
    }
}
