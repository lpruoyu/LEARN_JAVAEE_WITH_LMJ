package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test1")
public class TestController {

    @RequestMapping("/demo1")
    @ResponseBody
    public String demo1() {

        return "/test1/demo1";
    }

}
