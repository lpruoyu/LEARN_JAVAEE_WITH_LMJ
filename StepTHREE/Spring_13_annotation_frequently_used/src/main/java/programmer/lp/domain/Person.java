package programmer.lp.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@PropertySources({
        // 可以配置多个
        @PropertySource("user.properties")
})
public class Person {

    private Dog dog;

    private String name;
    private String nickName;

    @Autowired(required = false)
    @Qualifier("babyDog")
    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Value("${name}")
    public void setName(String name) {
        this.name = name;
    }

    @Value("${nickName}")
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    //    public Person() {
//    }
//
//    @Autowired
//    public Person(Dog dog) {
//        this.dog = dog;
//    }
//
//
//    public void setDog(Dog dog) {
//        this.dog = dog;
//    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", dog='" + dog + '\'' +
                '}';
    }
}
