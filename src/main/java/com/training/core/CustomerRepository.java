package com.training.core;

import static java.util.Arrays.asList;

import java.util.List;

import com.training.model.Customer;

public class CustomerRepository implements Repository {

    public List<Customer> staticData() {
        return asList(new Customer("Name01", "address01", "01651166", "email1@yopmail.com"),
            new Customer("Name02", "address02", "01651115", "email2@yopmail.com"),
            new Customer("Name03", "address03", "01651166", "emai3@yopmail.com"),
            new Customer("Name04", "address04", "01651164", "email4@yopmail.com"));
    }
    @Override
    public Customer getCustomerById(int id) {
        return staticData().get(id);
    }
}
