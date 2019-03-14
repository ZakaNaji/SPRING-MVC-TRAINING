package com.training.core;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.model.Customer;

@org.springframework.stereotype.Service
public class CustomerService implements Service {

    @Autowired Repository repository;

    @Override
    public List<Customer> customers() {
        return repository.getAllCustomers();
    }

    @Override
    public Customer getCustomerByName(String name) {
        return repository.getCustomerByName(name);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return repository.addCustomer(customer);
    }
}
