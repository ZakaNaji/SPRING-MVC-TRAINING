package com.training.core;

import static java.util.Arrays.asList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.training.model.Customer;

public class CustomerRepository implements Repository {

    /*private List<Customer> listOfCustomers;

    public CustomerRepository(){
        listOfCustomers = new ArrayList<>();
        listOfCustomers.add(new Customer("Name01", "address01", "01651166", "email1@yopmail.com"));
        listOfCustomers.add(new Customer("Name02", "address02", "01651115", "email2@yopmail.com"));
        listOfCustomers.add(new Customer("Name03", "address03", "01651166", "emai3@yopmail.com"));
        listOfCustomers.add(new Customer("Name04", "address04", "01651164", "email4@yopmail.com"));
    }
/*    public List<Customer> staticData() {
        return asList(new Customer("Name01", "address01", "01651166", "email1@yopmail.com"),
            new Customer("Name02", "address02", "01651115", "email2@yopmail.com"),
            new Customer("Name03", "address03", "01651166", "emai3@yopmail.com"),
            new Customer("Name04", "address04", "01651164", "email4@yopmail.com"));
    }*/

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Customer getCustomerByName(String name) {
        Map<String, Object> params = new HashMap<>();

        params.put("name",name);
        String sql = "SELECT * FROM customer where name = :name";
        return namedParameterJdbcTemplate.queryForObject(sql,params, new CustomerMapper());
        //return null;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", customer.getName());
        paramMap.put("address", customer.getAddress());
        paramMap.put("phone", customer.getPhone());
        paramMap.put("email", customer.getEmail());
        String sql = "insert into customer (name, address, phone, email) values (:name, :address, :phone,:email)";
        namedParameterJdbcTemplate.update(sql,paramMap);
        System.out.println(customer);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        Map<String, Object> params = new HashMap<>();
        String sql = "SELECT * FROM customer";
        return namedParameterJdbcTemplate.query(sql, params, new CustomerMapper());
    }

    private static final class CustomerMapper implements RowMapper<Customer> {
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer(rs.getString("name"),rs.getString("address"),rs.getString("phone"),rs.getString("email"));
            return customer;
        }
    }
}
