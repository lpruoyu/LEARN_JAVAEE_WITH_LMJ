package programmer.lp.cfg;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

//@Configuration
public class MyBatisConfig {
    @Bean
    public ConfigurationCustomizer customizer() {
        return (configuration) -> {
            configuration.setMapUnderscoreToCamelCase(true);
            configuration.setUseGeneratedKeys(true);
        };
    }
}