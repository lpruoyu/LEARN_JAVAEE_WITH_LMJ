package programmer.lp.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

//@Configuration
public class BeanConfiguration {
    @Bean
    @ConfigurationProperties("person")
    public programmer.lp.domain.Person person() {
        return new programmer.lp.domain.Person();
    }
}
