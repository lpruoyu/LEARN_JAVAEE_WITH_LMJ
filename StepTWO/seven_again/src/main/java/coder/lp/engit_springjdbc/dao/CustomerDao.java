package coder.lp.engit_springjdbc.dao;

import coder.lp.engit_springjdbc.bean.Customer;
import coder.lp.engit_springjdbc.utils.Dbs;

import java.sql.ResultSet;
import java.util.List;

public class CustomerDao {

    public boolean save(Customer customer) {
        final String sql = "INSERT INTO customer(name, age, height) VALUES(?, ?, ?)";
        return Dbs.update(sql, customer.getName(), customer.getAge(), customer.getHeight()) == 1;
    }


    public List<Customer> list() {
        final String sql = "SELECT id, name, age, height FROM customer";
        return Dbs.query(new Dbs.RowMapper<Customer>() {
            @Override
            public Customer generateBean(ResultSet resultSet) throws Exception {
                return new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getDouble("height")
                );
            }
        }, sql);
    }

}
