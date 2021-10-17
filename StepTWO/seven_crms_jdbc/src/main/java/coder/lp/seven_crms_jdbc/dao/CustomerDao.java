package coder.lp.seven_crms_jdbc.dao;

import coder.lp.seven_crms_jdbc.bean.Customer;
import coder.lp.seven_crms_jdbc.utils.Dbs;

import java.util.List;

public class CustomerDao {

    public List<Customer> customers() {
        final String sql = "SELECT id, name, age, height FROM customer";

        return Dbs.query((resultSet, row) -> {
//            System.out.println("表中的第" + row + "行记录");

            final Integer id = resultSet.getInt("id");
            final String name = resultSet.getString("name");
            final Integer age = resultSet.getInt("age");
            final Double height = resultSet.getDouble("height");
            return new Customer(id, name, age, height);
        }, sql);
    }

    public boolean saveCustomer(Customer customer) {
        final String sql = "INSERT INTO customer(name, age, height) VALUES(?, ?, ?)";
        return Dbs.update(sql, customer.getName(), customer.getAge(), customer.getHeight()) == 1;
    }

//        return Dbs.query(new Dbs.RowMapper<Customer>() {
//            @Override
//            public Customer generateBean(ResultSet resultSet, int row) throws SQLException {
//                System.out.println("表中的第" + row + "行记录。");
//
//                final Integer id = resultSet.getInt("id");
//                final String name = resultSet.getString("name");
//                final Integer age = resultSet.getInt("age");
//                final Double height = resultSet.getDouble("height");
//                return new Customer(id, name, age, height);
//            }
//        }, sql);
//    }


//    /**
//     * @return 返回所有的customer数据
//     */
//    public List<Customer> customers() {
//        final String mysqlDriver = "com.mysql.jdbc.Driver";
//        final String url = "jdbc:mysql://localhost:3306/my_db";
//        final String username = "root";
//        final String password = "root";
//        final String sql = "SELECT id, name, age, height FROM customer";
//        try {
//            Class.forName(mysqlDriver);
//        } catch (ClassNotFoundException e) {
//            System.err.println("MySQL数据库驱动加载失败!");
//            return null;
//        }
//        try (
//                final Connection connection = DriverManager.getConnection(url, username, password);
//                final PreparedStatement preparedStatement = connection.prepareStatement(sql);
//                final ResultSet resultSet = preparedStatement.executeQuery()
//        ) {
//
//            List<Customer> customers = new ArrayList<>(20);
//            while (resultSet.next()) {
//                final Integer id = resultSet.getInt("id");
//                final String name = resultSet.getString("name");
//                final Integer age = resultSet.getInt("age");
//                final Double height = resultSet.getDouble("height");
//
//                customers.add(new Customer(id, name, age, height));
//            }
//
//            return customers;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


//    /**
//     * @param customer 将customer保存到数据库中
//     * @return 数据保存是否成功
//     */
//    public boolean save(Customer customer) {
//        final String mysqlDriver = "com.mysql.jdbc.Driver";
//        final String url = "jdbc:mysql://localhost:3306/my_db";
//        final String username = "root";
//        final String password = "root";
//        final String sql = "INSERT INTO customer(name, age, height) VALUES(?, ?, ?)";
//        try {
//            Class.forName(mysqlDriver);
//        } catch (ClassNotFoundException e) {
//            System.err.println("MySQL数据库驱动加载失败!");
//            return false;
//        }
//        try (
//                final Connection connection = DriverManager.getConnection(url, username, password);
//                final PreparedStatement preparedStatement = connection.prepareStatement(sql)
//        ) {
//            preparedStatement.setString(1, customer.getName());
//            preparedStatement.setInt(2, customer.getAge());
//            preparedStatement.setDouble(3, customer.getHeight());
//            return preparedStatement.executeUpdate() == 1;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

}
