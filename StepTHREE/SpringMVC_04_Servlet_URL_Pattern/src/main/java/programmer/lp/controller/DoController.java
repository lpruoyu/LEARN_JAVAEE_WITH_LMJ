package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DoController {
//    @RequestMapping(value = "/test.do")
    @RequestMapping(value = "/test/test.do")
    @ResponseBody
    public String test(String username, String password) {
        System.out.println("username : " + username + ", password : " + password);
        return "<h1 style='color:red;'>热爱Coding,热爱Programming。</h1>";
    }
}
