package programmer.lp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "SB_JSP";
    }

    @GetMapping("/testJSP")
    public ModelAndView testJSP() {
        // 转发到：/test.jsp
        return new ModelAndView("test");
    }
}
