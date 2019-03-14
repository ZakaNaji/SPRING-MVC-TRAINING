package com.training.core;

import java.util.List;

import com.training.model.Customer;

public interface Repository {
    Customer getCustomerByName(String name);
    Customer addCustomer(Customer customer);
    List<Customer> getAllCustomers();
}
