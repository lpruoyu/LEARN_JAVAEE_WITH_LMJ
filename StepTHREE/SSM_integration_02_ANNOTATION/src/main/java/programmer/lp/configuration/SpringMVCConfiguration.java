package programmer.lp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import programmer.lp.converter.DateConverter;

import java.nio.charset.StandardCharsets;
import java.util.List;

@ComponentScan("programmer.lp.controller")
//@ComponentScan({"programmer.lp.controller", "programmer.lp.interceptor"})
@EnableWebMvc
public class SpringMVCConfiguration implements WebMvcConfigurer {

    @Autowired
    private DateConverter dateConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(dateConverter);
//        registry.addConverter(new IntegerConverter());
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        stringConverter.setDefaultCharset(StandardCharsets.UTF_8);
        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
        jacksonConverter.setDefaultCharset(StandardCharsets.UTF_8);
        converters.add(stringConverter);
        converters.add(jacksonConverter);
    }


    //    @Autowired
//    private MyInterceptor myInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(myInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/assets/**");
//    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }


    //    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/page/jsp");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }

//    @Bean
//    public HandlerInterceptor myInterceptor() {
//        return new MyInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(myInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/assets/**");
//    }

    /**
     * 相当于<mvc:default-servlet-handler/>
     * 用于处理静态资源
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
