package programmer.lp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// 我们都知道@Bean需要和@Configuration搭配使用
// 但在SpringBoot环境下，@Bean可以和@Component搭配使用
@Component
//@Configuration
public class SpringConfiguration {

    @Bean
    public List<String> list() {
        return new ArrayList<>();
    }

}
