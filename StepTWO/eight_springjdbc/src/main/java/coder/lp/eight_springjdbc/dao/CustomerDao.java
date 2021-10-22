package coder.lp.eight_springjdbc.dao;

import coder.lp.eight_springjdbc.bean.Customer;
import coder.lp.eight_springjdbc.utils.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public class CustomerDao {

    public boolean update(Customer customer) {
        final String sql = "UPDATE customer SET name=?, age=?, height=? WHERE ID = ?";
        return 1 == Dbs.jdbcTemplate().update(sql, customer.getName(), customer.getAge(), customer.getHeight(), customer.getId());
    }

    public boolean save(Customer customer) {
        final String sql = "INSERT INTO customer(name, age, height) VALUES(?, ?, ?)";
        return Dbs.jdbcTemplate().update(sql, customer.getName(), customer.getAge(), customer.getHeight()) == 1;
    }

    public boolean remove(Integer id) {
        final String sql = "DELETE FROM customer WHERE id = ?";
        return Dbs.jdbcTemplate().update(sql, id) == 1;
    }

    public List<Customer> list() {
        final String sql = "SELECT id, name, age, height FROM customer";
        return Dbs.jdbcTemplate().query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }

    public Customer edit(Integer id) {
        final String sql = "SELECT id, name, age, height FROM customer WHERE id = ?";
//        return Dbs.jdbcTemplate().query(sql, new BeanPropertyRowMapper<>(Customer.class), id).get(0);
        return Dbs.jdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<>(Customer.class), id);
    }

}

//    public List<Customer> list() {
//        final String sql = "SELECT id, name, age, height FROM customer";
//        return DbsUsingSpringJDBC.jdbcTemplate().query(sql, (resultSet, row) -> {
//            System.out.println("表中的第" + row + "行记录");
//
//            final Integer id = resultSet.getInt("id");
//            final String name = resultSet.getString("name");
//            final Integer age = resultSet.getInt("age");
//            final Double height = resultSet.getDouble("height");
//            return new Customer(id, name, age, height);
//        });
//    }
