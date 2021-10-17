package coder.lp.five_crms.bean;

public class Customer {

    private String name;
    private Integer age;
    private Float tall;

    public Customer(String name, Integer age, Float tall) {
        this.name = name;
        this.age = age;
        this.tall = tall;
    }

    public Customer() {
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

    public Float getTall() {
        return tall;
    }

    public void setTall(Float tall) {
        this.tall = tall;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", tall=" + tall +
                '}';
    }

}

