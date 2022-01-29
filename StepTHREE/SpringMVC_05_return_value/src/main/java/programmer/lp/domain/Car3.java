package programmer.lp.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Car3")
public class Car3 {
    private String name;
    private Integer price;
    @XmlElement
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
}
