package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/IRVR4")
public class JspController4 {
    @GetMapping("/jsp1")
    public String jsp1() {
        return "/jsp1";
    }

    @GetMapping("/jsp6")
    public String jsp6() {
        return "/jsp6";
    }
}
