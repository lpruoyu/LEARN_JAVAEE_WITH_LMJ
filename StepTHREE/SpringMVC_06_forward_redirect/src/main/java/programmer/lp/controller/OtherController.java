package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import programmer.lp.domain.Car;
import programmer.lp.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OtherController {

    @GetMapping("/other")
    @ResponseBody
    public String other() {
        return "This is other info.";
    }

    @GetMapping("/json")
    @ResponseBody
    public Person json() {
        Person person = new Person();
        person.setName("Tom");
        person.setAge(18);
        List<Car> cars = new ArrayList<>();
        person.setCars(cars);
        cars.add(new Car("Audi", 111.1));
        cars.add(new Car("Benz", 222.2));
        cars.add(new Car("BMW", 333.3));
        return person;
    }

}
