package com.components;

import com.learning.model.Customer;
import com.learning.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DependencyInjection {
    @Autowired
    private Customer customer;

    @Autowired
    private Person custom;

    @GetMapping("/getCustomerDetails")
    public Customer getCustomerDetails(){
        return customer;
    }

    @GetMapping("/custom")
    public Person getCustomBean(){

        return custom;
    }
}
