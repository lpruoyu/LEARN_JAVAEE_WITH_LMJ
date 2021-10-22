package coder.lp.engit_springjdbc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public final class Dbs {
    private Dbs() {
    }

    private static DataSource DATASOURCE;

    static {
        final InputStream is = Dbs.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            DATASOURCE = DruidDataSourceFactory.createDataSource(properties);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public interface RowMapper<T> {
        T generateBean(ResultSet resultSet) throws Exception;
    }

    public static <T> List<T> query(RowMapper<T> rowMapper, String sql, Object... args) {
        try (
                final PreparedStatement preparedStatement = DATASOURCE.getConnection().prepareStatement(sql)
        ) {
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            List<T> list = new ArrayList<>();
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(rowMapper.generateBean(resultSet));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int update(String sql, Object... args) {
        try (

                final PreparedStatement preparedStatement = DATASOURCE.getConnection().prepareStatement(sql)
        ) {
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}


//    private static String MYSQL_DRIVER;
//    private static String MYSQL_URL;
//    private static String MYSQL_USERNAME;
//    private static String MYSQL_PASSWORD;
//
//    static {
//        final InputStream is = Dbs.class.getClassLoader().getResourceAsStream("db.properties");
//        Properties properties = new Properties();
//        try {
//            properties.load(is);
//            MYSQL_DRIVER = properties.getProperty("mysql_driver");
//            MYSQL_URL = properties.getProperty("mysql_url");
//            MYSQL_USERNAME = properties.getProperty("mysql_username");
//            MYSQL_PASSWORD = properties.getProperty("mysql_password");
//            is.close();
//
//            Class.forName(MYSQL_DRIVER);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//        }
//    }
