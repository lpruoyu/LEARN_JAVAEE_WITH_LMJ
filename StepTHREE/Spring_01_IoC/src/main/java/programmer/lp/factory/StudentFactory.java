package programmer.lp.factory;

import programmer.lp.dao.StudentDao;
import programmer.lp.service.StudentService;

import java.io.InputStream;
import java.util.Properties;

public class StudentFactory {
    private static Properties properties;
    static {
        try (InputStream is = StudentFactory.class.getClassLoader().getResourceAsStream("student.properties")) {
            properties = new Properties();
            properties.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static StudentService getService() {
        return get("service");
    }
    public static StudentDao getDao() {
        return get("dao");
    }
    private static <T> T get(String param) {
        try {
            return (T) Class.forName(properties.getProperty(param)).getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
