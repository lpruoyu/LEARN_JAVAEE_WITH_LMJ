package coder.lp.eight_javascript.dao;


import coder.lp.eight_javascript.bean.Customer;
import coder.lp.eight_javascript.utils.Dbs;
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
