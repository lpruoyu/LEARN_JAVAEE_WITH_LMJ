package programmer.lp.factory;

import java.io.InputStream;
import java.util.Properties;

public class CommonFactory {

    private static Properties properties;

    static {
        try (InputStream is = CommonFactory.class.getClassLoader().getResourceAsStream("student.properties")) {
            properties = new Properties();
            properties.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> T get(String param) {
        try {
            return (T) Class.forName(properties.getProperty(param)).getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
