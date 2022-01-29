package programmer.lp.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Car {
    private String name;
    private Integer price;
    public Car() {
    }
    public Car(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
    @XmlAttribute
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @XmlAttribute
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
}
