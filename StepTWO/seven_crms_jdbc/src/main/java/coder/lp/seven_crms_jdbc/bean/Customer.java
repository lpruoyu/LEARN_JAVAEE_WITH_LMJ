package coder.lp.seven_crms_jdbc.bean;

public class Customer {

    private Integer id;
    private String name;
    private Integer age;
    private Double height;

    public Customer(Integer id, String name, Integer age, Double height) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public Customer(String name, Integer age, Double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

}

