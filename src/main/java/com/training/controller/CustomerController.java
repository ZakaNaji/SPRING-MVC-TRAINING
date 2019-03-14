package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.core.Service;
import com.training.model.Customer;

@Controller
public class CustomerController {

    @Autowired private Service service;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/getCustomer/{id}")
    public String getCustomerById(@PathVariable("id") String name, ModelMap modelMap){
        modelMap.addAttribute("customer",service.getCustomerByName(name));
        return "customer_detail";
    }

    @GetMapping("/addCustomer")
    public String addCustomerPage(){
        return "add_customer";
    }
    @PostMapping("addCustomer")
    public String addCustomerOps(@RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("email") String email, @RequestParam("phone") String phone){
        service.addCustomer(new Customer(name,address,phone,email));
        return "success_message";
    }
}
