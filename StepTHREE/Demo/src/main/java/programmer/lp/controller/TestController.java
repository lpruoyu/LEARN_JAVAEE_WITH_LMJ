package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello!";
    }

    @GetMapping("/exp")
    @ResponseBody
    public String exp() {
        return "exp!";
    }

    @GetMapping("/textPlain")
    @ResponseBody
    public String textPlain() {
        return "success!";
    }

    @GetMapping("/redirect")
    public String redirect() {
        return "redirect:/redirect.jsp";
    }

    @GetMapping("/forward")
    public String forward() {
        return "forward:/WEB-INF/jsp/forward.jsp";
    }

}
