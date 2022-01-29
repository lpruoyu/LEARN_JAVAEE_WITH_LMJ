package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import programmer.lp.domain.Car2;
import programmer.lp.domain.Person2;

@Controller
public class XML2Controller {
    /*
    要求返回的数据格式
    <?xml version="1.0" encoding="UTF-8"?>
    <person name="Jack" age="20">
        <car name="BMW" price="123"/>
    </person>
     */
    @GetMapping(value = "/xml2", produces = "application/xml;charset=utf-8")
    @ResponseBody
    public Person2 xml2() {
        // 从数据库中获取到数据
        Person2 person2 = new Person2();
        person2.setName("杰克");
        person2.setAge(20);
        Car2 car2 = new Car2();
        car2.setName("BMW");
        car2.setPrice(123);
        person2.setCar(car2);
        return person2;
    }
}

