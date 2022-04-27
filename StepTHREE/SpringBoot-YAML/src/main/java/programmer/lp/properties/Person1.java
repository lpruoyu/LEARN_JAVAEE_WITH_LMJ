package programmer.lp.domain;

import org.springframework.beans.factory.annotation.Value;

//@Component
public class Person1 {
    @Value("${id}")
    private Integer id;
    @Value("${age}")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
