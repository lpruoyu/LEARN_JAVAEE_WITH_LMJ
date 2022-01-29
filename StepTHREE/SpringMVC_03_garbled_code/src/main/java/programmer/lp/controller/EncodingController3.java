package programmer.lp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//@RequestMapping("/encoding")
public class EncodingController3 {
    @RequestMapping(value = "/login", produces = "text/html; charset=utf-8")
    @ResponseBody
    public String login(String username, String password) {
        System.err.println(username + "__" + password);
        return "Congratulation! 用户：<font color='red'>" + username + "</font>，登录成功!";
    }
}
