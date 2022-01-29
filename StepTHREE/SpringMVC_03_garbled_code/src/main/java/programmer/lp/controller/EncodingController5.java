package programmer.lp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//@RequestMapping("/encoding")
public class EncodingController5 {
    @RequestMapping("/test")
    @ResponseBody
    public String test(String username, String password) {
        return "<h1>热爱Coding,热爱Programming。</h1>";
    }
}
