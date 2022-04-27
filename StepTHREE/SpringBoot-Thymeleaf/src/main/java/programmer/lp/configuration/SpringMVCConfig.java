package programmer.lp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 设置首页
        registry.addViewController("/").setViewName("login");

        // 其他页面的映射，就可以不用在Controller中专门写一个方法了
        registry.addViewController("/i18n").setViewName("i18n");
//        registry.addViewController("/i18n/").setViewName("i18n");
        registry.addViewController("/comment").setViewName("comment");
//        registry.addViewController("/comment/").setViewName("comment");
    }
}
