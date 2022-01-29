package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Controller
public class TestController {
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "test——controller";
    }

    @GetMapping("/test2")
    @ResponseBody
    public String test2() {
        return "哈哈嘻嘻呵呵嘿嘿";
    }

    @PostMapping("/test3")
    @ResponseBody
    public String test3(String info) {
        System.out.println(info);
        return "success";
    }

    @GetMapping("/test4")
    @ResponseBody
    public String test4(Date birthday) {
        System.out.println(birthday);
        return "success";
    }

    @GetMapping("/test5")
    @ResponseBody
    public String test5(Integer number) {
        System.out.println(number);
        return "success";
    }

    @PostMapping("/test6")
    @ResponseBody
    public String test6(String name, MultipartFile file) {
        System.out.println(name);
        System.out.println(file.getOriginalFilename());
        return "success";
    }

}
