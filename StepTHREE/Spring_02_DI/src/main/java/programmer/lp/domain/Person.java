package programmer.lp.domain;

import java.util.Map;

public class Person {
    private String name;
    private Integer age;
    private Dog dog;
    private String[] nickNames;
    private Map<String, Dog> mapDogs;
    public Person() { }
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Map<String, Dog> getMapDogs() {
        return mapDogs;
    }

    public void setMapDogs(Map<String, Dog> mapDogs) {
        this.mapDogs = mapDogs;
    }

    public String[] getNickNames() {
        return nickNames;
    }

    public void setNickNames(String[] nickNames) {
        this.nickNames = nickNames;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Dog getDog() {
        return dog;
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

}
