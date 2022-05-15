package programmer.lp.jk.cfg;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig1 implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/users/*")
        registry.addMapping("/**")
//                .allowedOrigins("*")
                .allowedOrigins("http://localhost:63343")
                .allowCredentials(true) // 允许客户端发送Cookie
                .allowedMethods("GET", "POST");
    }
}
