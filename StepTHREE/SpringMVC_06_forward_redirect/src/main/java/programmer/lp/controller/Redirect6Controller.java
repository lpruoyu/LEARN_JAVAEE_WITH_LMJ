package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Redirect6Controller {
    @GetMapping("/redirect6")
    public String redirect6() {
        return "redirect:/jsp5";
    }
}
