package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Redirect4Controller {
    @GetMapping("/redirect4")
    public String redirect4() {
        return "redirect:/showInfo.jsp?name=lpruoyu&age=21";
    }
}
