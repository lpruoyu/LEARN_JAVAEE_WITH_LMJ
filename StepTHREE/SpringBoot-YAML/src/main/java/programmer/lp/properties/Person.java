package programmer.lp.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Person {
    private Integer id;
    private String name;
    private String[] nickNames;
    private Map<String, String> hobbies;
    private Dog dog;
    private List<Dog> dogs;

    @Data
    public static class Dog {
        private Integer age;
        private String name;
    }
}
