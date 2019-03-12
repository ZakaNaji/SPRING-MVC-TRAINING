package com.training.core;

import static java.util.Arrays.asList;

import java.util.List;

import com.training.model.Customer;

@org.springframework.stereotype.Service
public class CustomerService implements Service {

    @Override
    public List<Customer> customers() {
        return staticData();
    }

    public List<Customer> staticData() {
        return asList(new Customer("Name01", "address01", "01651166", "email1@yopmail.com"),
            new Customer("Name02", "address02", "01651115", "email2@yopmail.com"),
            new Customer("Name03", "address03", "01651166", "emai3@yopmail.com"),
            new Customer("Name04", "address04", "01651164", "email4@yopmail.com"));
    }
}
