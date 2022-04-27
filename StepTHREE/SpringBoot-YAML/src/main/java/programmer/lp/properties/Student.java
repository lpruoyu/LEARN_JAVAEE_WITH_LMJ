package programmer.lp.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;

//@ConfigurationProperties(prefix = "student")
//@ConfigurationProperties("student")
//@Data
public class Student {
    private Integer id;
    private String name;
    // List、Set、数组，yml的写法是一样的
    private String[] nickNames;
    private Map<String, String> hobbies;
    private Dog dog;
    private List<Dog> dogs;

    @Data
    private static class Dog {
        private Integer age;
        private String name;
    }
}
