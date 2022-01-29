package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/test2")
public class TestController2 {
    @GetMapping("/demo1")
    @ResponseBody
    public String demo1(@RequestParam Map<String, Object> map) {
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
        return "success!";
    }
}
