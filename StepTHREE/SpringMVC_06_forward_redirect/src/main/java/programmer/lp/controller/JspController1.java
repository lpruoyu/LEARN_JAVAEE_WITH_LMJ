package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/IRVR")
public class JspController1 {
    @GetMapping("/jsp1")
    public String jsp1() {
        return "/jsp1";
    }

    @GetMapping("/jsp6")
    public ModelAndView jsp6() {
        return new ModelAndView("/public/jsp6.jsp");
    }
}
