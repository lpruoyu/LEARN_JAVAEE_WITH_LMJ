package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test4")
public class TestController4 {
    @RequestMapping("/demo1")
    @ResponseBody
    public String demo1(String username, String password) {
        System.out.println(username + "__" + password);
        return "/test4/demo1 success!";
    }
}
