package programmer.lp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/plain")
public class Plain2Controller {
    @GetMapping(value = "/test1", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String test1(HttpServletResponse response) {
        response.setStatus(400);
        return "test1";
    }

    @GetMapping(value = "/test2", produces = "text/plain;charset=utf-8")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "你这个请求太拉了")
    public String test2() {
        return "test2";
    }

    // 请求我/other/下的任意路径，都会触发
    @RequestMapping("/other/{path}")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "你这个请求有点离谱！")
    public String wrong() {
        return null;
    }

}