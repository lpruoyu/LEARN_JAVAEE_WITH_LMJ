package coder.lp.main;

import java.sql.*;

public class Main {

    private static final String user = "root";
    private static final String password = "root";

    public static void main(String[] args) throws Exception {
        login("", "' OR '1' = '1");
        login("123", "root");
        login("root", "123");
        System.out.println("-----------------------------");
        login("lpruoyu", "lpruoyu");
        login("root", "root");
        login("123", "123");
    }

    private static void login(String name, String pswd) throws Exception {
        final String mysqlURL = "jdbc:mysql://localhost:3306/xmg?serverTimezone=UTC";
        final String user = "root";
        final String password = "root";
        final String sql = "SELECT * FROM user WHERE name = ? AND pswd = ?";
        try (
                Connection connection = DriverManager.getConnection(mysqlURL, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, pswd);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                System.out.println("登录成功！");
            } else {
                System.out.println("登录失败！");
            }

            // ResultSet没法使用try-with-resources
            // 所以ResultSet需要关闭
            resultSet.close();
        }
    }

    private static void test5(String name, String pswd) throws Exception {
        final String mysqlURL = "jdbc:mysql://localhost:3306/xmg?serverTimezone=UTC";
        final String user = "root";
        final String password = "root";
        final String sql = "SELECT * FROM user WHERE name = '" + name + "' AND pswd = '" + pswd + "'";
        try (
                Connection connection = DriverManager.getConnection(mysqlURL, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {

            System.out.println(sql);

            // 返回结果只可能有1条或者0条
            if (resultSet.next()) { // 返回值有一条记录 找到该用户
                System.out.println("登录成功！");
            } else { // 没有返回值 没有找到该用户
                System.out.println("登录失败，用户名或密码不正确！");
            }
        }
    }

    private static void test4() throws Exception {
        final String mysqlURL = "jdbc:mysql://localhost:3306/xmg?serverTimezone=UTC";
        final String user = "root";
        final String password = "root";
        final String sql = "SELECT company_id myCpid FROM customer";
        try (
                Connection connection = DriverManager.getConnection(mysqlURL, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                Object myCpid = resultSet.getObject("myCpid");
                if (myCpid != null) {
                    // 执行相应的操作
                    int id = (Integer) myCpid;
                }
            }
        }
    }

    private static void test3() throws Exception {
        final String mysqlURL = "jdbc:mysql://localhost:3306/xmg?serverTimezone=UTC";
        final String user = "root";
        final String password = "root";
        final String sql = "SELECT * FROM customer";
        try (
                Connection connection = DriverManager.getConnection(mysqlURL, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                System.out.println(
                        "name : " + resultSet.getString("name") + " ;" +
                                "phone : " + resultSet.getString("phone") + " ;" +
                                "company id : " + resultSet.getInt("company_id")
                );
            }
        }
    }

    private static void test2() {
        final String DRIVER_MYSQL = "com.mysql.cj.jdbc.Driver";
        final String mysqlURL = "jdbc:mysql://localhost:3306/xmg?serverTimezone=UTC";
        try {
            // Java SE 6开始就不用显示加载驱动了
            // 这儿显示加载驱动的目的是为了学习这块的知识点
            Class.forName(DRIVER_MYSQL);
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败！");
        }

        try (
                Connection connection = DriverManager.getConnection(mysqlURL, user, password);
                Statement statement = connection.createStatement()
        ) {
            final String sql = "INSERT INTO customer (id, name, phone, company_id) VALUES (104, 'hahaha', '44444444444', 3)";
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JDBC属于JavaSE的一部分 具体看图示Java.png */
    /* 最基本的JDBC访问MySQL程序 */
    public static void test1() throws Exception {
        final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
        /* 步骤一： 将Driver注册到DriverManager 加载驱动 */
        // 方式一 推荐使用 装载MySQL驱动类
        Class.forName(DRIVER_MYSQL);
        //  方式二 不推荐使用
        //  DriverManager.registerDriver(new Driver());

        /* 步骤二：利用DriverManager创建数据库连接 获取数据库连接对象 */
        // url：数据库服务器地址
        final String mysqlURL = "jdbc:mysql://localhost:3306/xmg";
        final String user = "root";
        final String password = "root";
        Connection connection = DriverManager.getConnection(mysqlURL, user, password);

        /* 步骤三：利用Connection创建SQL语句对象 */
        Statement statement = connection.createStatement();

        /* 步骤四：执行SQL语句 SQL语句不用加;*/
        final String sql = "INSERT INTO customer (id, name, phone, company_id) VALUES (101, 'lphahaha', '11122223333', 1)";
        statement.execute(sql);

        /* 步骤五：关闭释放资源 */
        statement.close();
        connection.close();
    }

}