package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import programmer.lp.domain.Car;
import programmer.lp.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Controller
public class XML4Controller {
    /*
    要求返回的数据格式：
    <person name="Tom" age="18">
        <cars>
            <car name="Audi" price="111"/>
            <car name="Benz" price="222"/>
            <car name="BMW" price="333"/>
        </cars>
    </person>
     */
    @GetMapping( "/xml4")
    @ResponseBody
    public Person xml4() {
        // 从数据库中获取到数据
        Person person = new Person();
        person.setName("Tom");
        person.setAge(18);
        List<Car> cars = new ArrayList<>();
        person.setCars(cars);
        cars.add(new Car("Audi", 111));
        cars.add(new Car("Benz", 222));
        cars.add(new Car("BMW", 333));
        return person;
    }
}
