package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/encoding")
public class EncodingController {
    @RequestMapping(value = "/test", produces = "text/plain")
    @ResponseBody
    public String test(String username, String password) {
        return "热爱Coding,热爱Programming。";
    }
}
