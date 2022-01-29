package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import programmer.lp.domain.Person;

@Controller
public class TestController {
    @GetMapping("/test1")
    @ResponseBody                                 // required默认为true
    public String test1(@RequestParam(value = "name") String name,
                        @RequestParam(value = "age", required = false) String age) {
        System.out.println(name + "__" + age);
        return "success!";
    }

    @GetMapping("/test2")
    @ResponseBody
    public String test2(Person person) {
        System.out.println("person.name: " + person.getName() + "__person.age: " + person.getAge());
        return "success!";
    }
}
