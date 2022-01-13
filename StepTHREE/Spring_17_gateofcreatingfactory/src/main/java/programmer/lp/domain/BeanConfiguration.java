package programmer.lp.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("programmer.lp")
@ImportResource("applicationContext.xml")
public class BeanConfiguration {

    @Bean
    public Dog dog() {
        return new Dog();
    }

    @Bean
    public Person person() {
        return new Person();
    }

}
