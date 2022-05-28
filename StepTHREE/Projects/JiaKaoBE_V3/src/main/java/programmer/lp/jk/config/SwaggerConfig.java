package programmer.lp.jk.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import programmer.lp.jk.prop.SwaggerProperties;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements InitializingBean {
    @Bean
    public Docket examDocket() {
        return getDocket("考试",
                "包含模块：考场、科1科4、科2科3",
                "/exam.+");
    }

    @Bean
    public Docket dictDocket() {
        return getDocket("数据字典",
                "包含模块：数据字典类型、数据字典条目、省份、城市",
                "/(dict.+|plateRegions.+)");
    }

    @Autowired
    private SwaggerProperties swaggerProperties;
    @Autowired
    private Environment environment;

    private Class[] ignoredParameterTypes;
    private boolean enable;

    private Class[] getIgnoredParameterTypes() {
        final List<Class<?>> iptClasses = new ArrayList<>();
        swaggerProperties.getIgnoredParameterTypes().forEach(v -> {
            try {
                iptClasses.add(Class.forName(v));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        return iptClasses.toArray(new Class[iptClasses.size()]);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ignoredParameterTypes = getIgnoredParameterTypes();
        enable = !environment.acceptsProfiles(Profiles.of("prd"));
    }

    private Docket getDocket(String groupName, String description, String pathRegex) {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .groupName(groupName)
                .ignoredParameterTypes(ignoredParameterTypes)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.regex(pathRegex))
                .build()
                .apiInfo(apiInfo(swaggerProperties.getTitle() + groupName, description));
    }

    private ApiInfo apiInfo(String title, String description) {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(swaggerProperties.getVersion())
                .contact(new Contact(
                        swaggerProperties.getName(),
                        swaggerProperties.getUrl(),
                        swaggerProperties.getEmail()))
                .build();
    }
}
