package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.core.Service;
import com.training.model.Customer;

@RestController
public class CustomerRestController {

    @Autowired
    private Service customerService;

    @GetMapping(value = "/customers",produces = "application/json" )
    public List<Customer> customers() {
        return customerService.customers();
    }
}
