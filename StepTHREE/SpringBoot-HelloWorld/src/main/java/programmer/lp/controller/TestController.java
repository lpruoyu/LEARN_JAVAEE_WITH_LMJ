package programmer.lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private List<String> list;

    @GetMapping("/test")
    public String test() {
//        return "Hello SpringBoot, Apply yourself!";
        return "Hello, SpringBoot!";
    }

}
