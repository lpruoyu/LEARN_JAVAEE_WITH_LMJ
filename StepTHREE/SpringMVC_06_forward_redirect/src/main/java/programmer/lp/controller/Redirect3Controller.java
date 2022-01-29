package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Redirect3Controller {
    @GetMapping("/redirect3")
    public ModelAndView redirect3() {
        return new ModelAndView("redirect:/login.jsp");
    }
}
