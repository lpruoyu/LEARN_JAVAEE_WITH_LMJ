package programmer.lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import programmer.lp.domain.Person;

//@RestController
public class TestController1 {
    @Value("${name}")
    private String name;
    @Autowired
    private Person person;

    @GetMapping("/test")
    public String test() {
        System.out.println(person);
        return "test" + name;
    }
}
