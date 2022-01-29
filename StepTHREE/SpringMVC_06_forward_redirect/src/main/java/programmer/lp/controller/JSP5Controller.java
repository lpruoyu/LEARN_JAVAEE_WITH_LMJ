package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JSP5Controller {
    @GetMapping("/jsp5")
    public String jsp5(HttpServletRequest request) {
        request.setAttribute("value", "好好学习！振兴中华！");
        return "/WEB-INF/jsp/jsp5.jsp";
    }
}
