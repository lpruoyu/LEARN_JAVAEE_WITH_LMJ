package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Redirect2Controller {
    @GetMapping("/redirect2")
    public String redirect2() {
        return "redirect:/login.jsp";
    }
}
