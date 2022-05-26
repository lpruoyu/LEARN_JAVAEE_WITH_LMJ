package programmer.lp.jk.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ConfigurationProperties("swagger")
public class SwaggerProperties {
    String title;
    String version;
    String name;
    String url;
    String email;
    List<String> ignoredParameterTypes;
}
