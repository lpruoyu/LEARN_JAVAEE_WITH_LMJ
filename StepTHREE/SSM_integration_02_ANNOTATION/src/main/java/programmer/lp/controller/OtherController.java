package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/other")
public class OtherController {
    @GetMapping("/demo1")
    public String demo1() {
        return "/welcome";
    }
}
