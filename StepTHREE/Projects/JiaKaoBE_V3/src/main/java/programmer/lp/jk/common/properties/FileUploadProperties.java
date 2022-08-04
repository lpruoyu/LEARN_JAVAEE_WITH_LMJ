package programmer.lp.jk.common.properties;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("fileupload")
public class FileUploadProperties implements ApplicationContextAware {
    private static FileUploadProperties properties;

    public static FileUploadProperties getInstance() {
        return properties;
    }

    private String basePath;
    private String uploadPath;
    private String imagePath;
    private String videoPath;

    public String getImageRelativePath() {
        return uploadPath + imagePath;
    }

    public String getVideoRelativePath() {
        return uploadPath + videoPath;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        properties = this;
    }
}
