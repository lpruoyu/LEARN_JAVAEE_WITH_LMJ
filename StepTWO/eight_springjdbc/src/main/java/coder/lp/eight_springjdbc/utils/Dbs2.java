package coder.lp.eight_springjdbc.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public final class Dbs2 {
    private Dbs2() {
    }

    private static DataSource DATASOURCE;

    static {
        Properties properties = new Properties();
        try (final InputStream is = Dbs2.class.getClassLoader().getResourceAsStream("druid.properties")) {
            properties.load(is);
            DATASOURCE = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
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