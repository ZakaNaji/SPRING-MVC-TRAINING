package com.training.core;

import java.util.List;

import com.training.model.Customer;

public interface Service {

    List<Customer> customers();
    Customer getCustomerByName(String name);
    Customer addCustomer(Customer customer);

}
