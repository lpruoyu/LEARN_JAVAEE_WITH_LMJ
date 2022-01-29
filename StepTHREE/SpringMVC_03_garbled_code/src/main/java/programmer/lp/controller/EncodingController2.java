package programmer.lp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//@RequestMapping("/encoding")
public class EncodingController2 {
    @GetMapping("/get")
    @ResponseBody
    public String get(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        return "get!";
    }

    @PostMapping("/post")
    @ResponseBody
    public String post(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        return "post!";
    }
}
