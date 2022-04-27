package programmer.lp.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("project")
public class ProjectProperties {

    private Uploads uploads;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Uploads {
        private String basePath;
        private String imagePath;
        private String videoPath;
        private String othersPath;
    }

}
