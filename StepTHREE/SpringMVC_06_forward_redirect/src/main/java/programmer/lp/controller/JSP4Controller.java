package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JSP4Controller {
    @GetMapping("/jsp4")
    public String jsp4() {
        return "/WEB-INF/jsp/jsp4.jsp";
    }
}
