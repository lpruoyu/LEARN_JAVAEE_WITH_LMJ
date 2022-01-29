package programmer.lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import programmer.lp.domain.Car3;
import programmer.lp.domain.Person3;

@Controller
public class XML3Controller {
    /*
    要求返回的数据格式：
    <Person3>
        <name>Jerry</name>
        <age>16</age>
        <Car3>
            <name>Audi</name>
            <price>222</price>
        </Car3>
    </Person3>
     */
    @GetMapping(value = "/xml3", produces = "application/xml;charset=utf-8")
    @ResponseBody
    public Person3 xml3() {
        // 从数据库中获取到数据
        Person3 person3 = new Person3();
        person3.setName("Jerry");
        person3.setAge(16);
        Car3 car3 = new Car3();
        car3.setName("Audi");
        car3.setPrice(222);
        person3.setCar(car3);
        return person3;
    }
}

