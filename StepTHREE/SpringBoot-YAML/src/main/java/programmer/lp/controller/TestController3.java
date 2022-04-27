package programmer.lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import programmer.lp.domain.Student;

//@RestController
//@EnableConfigurationProperties(Student.class)
public class TestController3 {
    @Autowired
    private Student student;

    @GetMapping("/test")
    public String test() {
        System.out.println(student);
        return "test";
    }
}
