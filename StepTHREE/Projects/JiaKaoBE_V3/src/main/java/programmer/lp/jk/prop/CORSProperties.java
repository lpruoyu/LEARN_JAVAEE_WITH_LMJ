package programmer.lp.jk.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("cors")
public class CORSProperties {
    String pathPattern; // 允许哪些路径下的API被跨域访问
    String[] origins; // 允许跨域请求的源
    String[] methods; // 允许跨域请求的方法类型
    boolean allowCredentials; // 是否允许Cookie
}
