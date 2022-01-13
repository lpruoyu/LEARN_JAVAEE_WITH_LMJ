package programmer.lp.domain;

import org.springframework.context.annotation.Bean;

//@Configuration
public class BeanConfiguration2 {

    @Bean
    public Human human() {
        return new Human();
    }

    @Bean
    public Food food() {
        return new Food();
    }

}
