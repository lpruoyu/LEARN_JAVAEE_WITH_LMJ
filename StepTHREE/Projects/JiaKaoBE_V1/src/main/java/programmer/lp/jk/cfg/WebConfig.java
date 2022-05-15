package programmer.lp.jk.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import programmer.lp.jk.pojo.prop.CORSProperties;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private CORSProperties corsProperties;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(corsProperties.getPathPattern())
                .allowedOrigins(corsProperties.getOrigins())
                .allowCredentials(corsProperties.isAllowCredentials())
                .allowedMethods(corsProperties.getMethods());
    }
}
