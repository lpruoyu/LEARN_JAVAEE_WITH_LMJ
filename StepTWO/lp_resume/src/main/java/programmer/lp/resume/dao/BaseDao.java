package programmer.lp.resume.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.InputStream;
import java.util.Properties;

public class BaseDao {

    protected static JdbcTemplate jdbcTemplate;

    static {
        try (
                InputStream is = WebsiteDao.class.getClassLoader().getResourceAsStream("druid.properties")
        ) {
            Properties properties = new Properties();
            properties.load(is);
            jdbcTemplate = new JdbcTemplate(DruidDataSourceFactory.createDataSource(properties));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
