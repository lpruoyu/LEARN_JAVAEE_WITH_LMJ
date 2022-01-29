package programmer.lp.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person2 {
    private String name;
    private Integer age;
    private Car2 car2;
    @XmlAttribute
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @XmlAttribute
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @XmlElement
    public Car2 getCar() {
        return car2;
    }
    public void setCar(Car2 car2) {
        this.car2 = car2;
    }
}
