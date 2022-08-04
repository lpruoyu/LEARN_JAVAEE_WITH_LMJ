package programmer.lp.jk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import programmer.lp.jk.common.filter.ErrorFilter;
import programmer.lp.jk.common.properties.CORSProperties;

import javax.servlet.Filter;

@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {
    @Autowired
    private CORSProperties corsProperties;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(corsProperties.getPathPattern())
                .allowedOrigins(corsProperties.getOrigins())
                .allowCredentials(corsProperties.isAllowCredentials())
                .allowedMethods(corsProperties.getMethods());
    }

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        // 设置Filter
        bean.setFilter(new ErrorFilter());
        bean.addUrlPatterns("/*");
        // 最高权限
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
