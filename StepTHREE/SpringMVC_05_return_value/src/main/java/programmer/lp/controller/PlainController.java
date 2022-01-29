package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlainController {
    @GetMapping(value = "/plainText", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String plainText() {
        return "好好读书！Good!";
    }
}

