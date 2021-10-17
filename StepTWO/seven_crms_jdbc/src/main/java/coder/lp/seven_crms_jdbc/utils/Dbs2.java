package coder.lp.seven_crms_jdbc.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public final class Dbs2 {

    /*
        这些常量不应该写死。
        因为到时候需要将项目中的.java文件编译为.class文件部署到服务器上
        如果将这些常量写死的话，到时候如果MySQL服务器的用户名或者密码发生改变的话，
        只能将该项目修改后再次编译为.class文件，然后再次部署到服务器上，这样会很麻烦。
    */

//    public static String final MYSQL_DRIVER = "com.mysql.jdbc.Driver";
//    public static String final MYSQL_URL = "jdbc:mysql://localhost:3306/my_db";
//    public static String final MYSQL_USERNAME = "root";
//    public static String final MYSQL_PASSWORD = "root";

    private static String MYSQL_DRIVER;
    private static String MYSQL_URL;
    private static String MYSQL_USERNAME;
    private static String MYSQL_PASSWORD;

    static {
        Properties properties = new Properties();
        try (InputStream is = Dbs2.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(is);
            MYSQL_DRIVER = properties.getProperty("mysql_driver");
            MYSQL_URL = properties.getProperty("mysql_url");
            MYSQL_USERNAME = properties.getProperty("mysql_username");
            MYSQL_PASSWORD = properties.getProperty("mysql_password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            Class.forName(MYSQL_DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL数据库驱动加载失败!");
        }
    }

    /**
     * 执行 DML、DDL语句
     *
     * @param sql
     * @return 是否执行成功
     */
    public static int update(final String sql, Object... args) {
        try (
                final Connection connection = DriverManager.getConnection(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
                final PreparedStatement preparedStatement = connection.prepareStatement(sql)
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

    public interface RowMapper<T> {
        T generateBean(ResultSet resultSet, int row) throws SQLException;
    }

    /**
     * 执行 DQL语句
     *
     * @param rowMapper 让用户自己创建Bean对象
     * @param sql       sql语句
     * @param args      sql语句中的参数
     * @param <T>       Bean类型
     * @return 查询出的结果
     */
    public static <T> List<T> query(RowMapper<T> rowMapper, String sql, Object... args) {
        if (null == rowMapper) return null;

        ResultSet resultSet = null;
        try (
                final Connection connection = DriverManager.getConnection(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
                final PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {


            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();

            List<T> list = new ArrayList<>();
            // 表中的数据 行是从0开始的，列是从1开始的
            int row = 0; // 告诉当前正在操纵第几行的数据
            while (resultSet.next()) {
                list.add(rowMapper.generateBean(resultSet, row++));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != resultSet) resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

}
