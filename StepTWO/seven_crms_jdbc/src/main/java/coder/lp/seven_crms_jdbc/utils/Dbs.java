package coder.lp.seven_crms_jdbc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public final class Dbs {

    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try (InputStream is = Dbs.class.getClassLoader().getResourceAsStream("druid.properties")) {
            properties.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int update(final String sql, Object... args) {
        try (PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql)) {
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public interface RowMapper<T> {
        T generateBean(ResultSet resultSet, int row) throws SQLException;
    }

    public static <T> List<T> query(RowMapper<T> rowMapper, String sql, Object... args) {
        if (null == rowMapper) return null;

        try (
                final PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
        ) {

            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            List<T> list = new ArrayList<>();
            int row = 0;

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(rowMapper.generateBean(resultSet, row++));
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

}
