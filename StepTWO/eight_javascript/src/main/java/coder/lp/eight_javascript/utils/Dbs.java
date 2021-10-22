package coder.lp.eight_javascript.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.InputStream;
import java.util.Properties;

public final class Dbs {

    private Dbs() {}

    private static JdbcTemplate JDBCTEMPLATE;

    static {
        try (final InputStream is = Dbs.class.getClassLoader().getResourceAsStream("druid.properties")) {
            Properties properties = new Properties();
            properties.load(is);
            JDBCTEMPLATE = new JdbcTemplate(DruidDataSourceFactory.createDataSource(properties));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JdbcTemplate jdbcTemplate() {
        return JDBCTEMPLATE;
    }

}