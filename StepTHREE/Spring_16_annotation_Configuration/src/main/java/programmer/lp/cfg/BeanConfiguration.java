package programmer.lp.cfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import programmer.lp.domain.Dog;
import programmer.lp.domain.Food;
import programmer.lp.domain.Human;
import programmer.lp.factorybean.FoodFactoryBean;

@Configuration
@PropertySource("dog.properties")
public class BeanConfiguration {
    private String dogName;
    private String dogNickName;

    @Value("${name}")
    public void setDogName(String dogName) {
        this.dogName = dogName;
    }
    @Value("${nickName}")
    public void setDogNickName(String dogNickName) {
        this.dogNickName = dogNickName;
    }

    @Bean
    public Dog dog() {
        Dog dog = new Dog();
        dog.setName(dogName);
        dog.setNickName(dogNickName);
        return dog;
    }

//    @Bean
//    public Human human() {
//        Human human = new Human();
//        human.setFood(food());
//        return human;
//    }

    @Bean
    public Human human(Food food) {
        Human human = new Human();
        human.setFood(food);
        return human;
    }

//    @Bean
//    public DogFactoryBean dog() {
//        return new DogFactoryBean();
//    }
    @Bean
    public FoodFactoryBean food() {
        return new FoodFactoryBean();
    }
}
