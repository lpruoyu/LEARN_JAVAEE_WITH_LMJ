package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import programmer.lp.domain.Car1;
import programmer.lp.domain.Person1;

@Controller
public class XML1Controller {
    /*
    要求返回的数据格式
    <?xml version="1.0" encoding="UTF-8"?>
    <person name="Jack" age="20">
        <car name="BMW" price="123"/>
    </person>
     */
    @GetMapping(value = "/xml1", produces = "application/xml;charset=utf-8")
    @ResponseBody
    public String xml1() {
        // 从数据库中获取到数据
        Person1 person = new Person1();
        person.setName("Jack");
        person.setAge(20);
        Car1 car = new Car1();
        car.setPrice(123);
        car.setName("BMW");
        person.setCar1(car);

        // 用第三方库将Model对象转为XML字符串（很多这样的库）
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<person name=\"" + person.getName() + "\" age=\"" + person.getAge() + "\">\n" +
                "    <car name=\"" + car.getName() + "\" price=\"" + car.getPrice() + "\"/>\n" +
                "</person>";
    }
}

