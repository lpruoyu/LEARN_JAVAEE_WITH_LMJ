package programmer.lp.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Person {
    private String name;
    private Integer age;
    private List<Car> cars;
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
    public List<Car> getCars() {
        return cars;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
