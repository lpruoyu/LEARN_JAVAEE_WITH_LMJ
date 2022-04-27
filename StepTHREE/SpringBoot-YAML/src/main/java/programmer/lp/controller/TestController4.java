package programmer.lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import programmer.lp.domain.Cat;

//@RestController
//@EnableConfigurationProperties(Cat.class)
public class TestController4 {
    @Autowired
    private Cat cat;

    @GetMapping("/test")
    public String test() {
        System.out.println(cat);
        return "test";
    }
}
