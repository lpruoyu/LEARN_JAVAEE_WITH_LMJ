package programmer.lp.jk.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import programmer.lp.jk.common.properties.SwaggerProperties;
import programmer.lp.jk.common.shiro.TokenFilter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Configuration
public class SwaggerConfig implements InitializingBean {
    @Bean
    public Docket sysDocket() {
        return getDocket("01_系统",
                "包含模块：用户、角色、资源",
                "/sys.*");
    }

    @Bean
    public Docket examDocket() {
        return getDocket("02_考试",
                "包含模块：考场、科1科4、科2科3",
                "/exam.*");
    }

    @Bean
    public Docket dictDocket() {
        return getDocket("03_数据字典",
                "包含模块：数据字典类型、数据字典条目、省份、城市",
                "/(dict.*|plate.*)");
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
        Parameter token = new ParameterBuilder()
                .name(TokenFilter.HEADER_TOKEN)
                .description("用户登录令牌")
                .parameterType("header")
                .modelRef(new ModelRef("String"))
                .required(false)
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(Arrays.asList(token))
                .ignoredParameterTypes(ignoredParameterTypes)
                .enable(enable)
                .groupName(groupName)
                .apiInfo(apiInfo(swaggerProperties.getTitle() + groupName, description))
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.regex(pathRegex))
                .build();
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
