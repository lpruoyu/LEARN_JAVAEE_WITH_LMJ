package programmer.lp.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("jdbc")
@Data
public class JdbcProperties {
    private String driverClassName;
    private String username;
    private String password;
    private String url;
}
