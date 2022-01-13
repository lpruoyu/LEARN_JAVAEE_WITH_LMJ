package programmer.lp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@PropertySource("db.properties")
@ImportResource("applicationContext.xml")
public class MainConfiguration {

//    // @Bean必须配合@Configuration使用
//    @Bean
//    public PropertySourcesPlaceholderConfigurer configurer() {
//        PropertySourcesPlaceholderConfigurer configurer =
//                new PropertySourcesPlaceholderConfigurer();
//        configurer.setLocation(new ClassPathResource("db.properties"));
//        return configurer;
//    }

}
