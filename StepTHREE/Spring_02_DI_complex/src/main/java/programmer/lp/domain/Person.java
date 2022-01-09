package programmer.lp.domain;

import java.beans.ConstructorProperties;

public class Person {
    private String name;
    private Integer age;
    private Dog dog;

    public Person() {
    }

    @ConstructorProperties({"name", "age"})
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
