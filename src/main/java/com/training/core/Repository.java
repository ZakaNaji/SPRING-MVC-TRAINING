package com.training.core;

import com.training.model.Customer;

public interface Repository {
    Customer getCustomerById(int id);
}
