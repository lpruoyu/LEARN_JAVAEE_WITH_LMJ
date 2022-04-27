package programmer.lp.domain;

import lombok.ToString;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;
import java.util.Map;

//@ConfigurationProperties(prefix = "cat")
// @ConfigurationProperties(value = "cat")
//@ConfigurationProperties("cat")
// 由于是通过构造方法注入的，因此不需要getter、setter，于是不使用@Data
//@ToString
//@ConstructorBinding
public class Cat {
    private Integer id;
    private String name;
    private String[] nickNames;
    private Map<String, String> hobbies;
    private Dog dog;
    private List<Dog> dogs;

    public Cat(Integer id, String name, String[] nickNames, Map<String, String> hobbies, Dog dog, List<Dog> dogs) {
        this.id = id;
        this.name = name;
        this.nickNames = nickNames;
        this.hobbies = hobbies;
        this.dog = dog;
        this.dogs = dogs;
    }

    @ToString
    @ConstructorBinding
    public static class Dog {
        private Integer age;
        private String name;

        public Dog(Integer age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
