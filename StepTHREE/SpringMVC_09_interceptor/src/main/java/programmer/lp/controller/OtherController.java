package programmer.lp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class OtherController {

    @GetMapping("/forward")
    public String forward() {
        return "forward:/assets/page/html/login.html";
    }

    @GetMapping("/redirect")
    public String redirect() {
        return "redirect:/assets/page/html/login.html";
    }

    // 请求/other下的任意路径，都会触发
    @RequestMapping("/other/**")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "你这个请求有点离谱！")
    public String wrong() {
        return null;
    }

}
