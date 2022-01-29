package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "<h1 style=\"color: green;\">Controller-hello</h1>";
    }
}

