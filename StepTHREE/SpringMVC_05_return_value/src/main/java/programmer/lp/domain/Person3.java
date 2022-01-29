package programmer.lp.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Person3")
public class Person3 {
    private String name;
    private Integer age;
    private Car3 car3;
    @XmlElement
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @XmlElement(name = "Car3")
    public Car3 getCar() {
        return car3;
    }
    public void setCar(Car3 car3) {
        this.car3 = car3;
    }
}
