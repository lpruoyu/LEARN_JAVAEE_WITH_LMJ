package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import programmer.lp.domain.Dog;
import programmer.lp.domain.Student;

import java.util.Arrays;

@Controller
public class JSON2Controller {
    @GetMapping( "/json2")
    @ResponseBody
    public Student json2() {
        Student student = new Student();
        student.setName("Jack");
        student.setAge(20);
        student.setNickNames(Arrays.asList("123", "456", "789"));
        Dog dog = new Dog();
        dog.setName("奔驰");
//        dog.setName("Benz");
        dog.setPrice(100);
        student.setDog(dog);
        return student;
    }
}

