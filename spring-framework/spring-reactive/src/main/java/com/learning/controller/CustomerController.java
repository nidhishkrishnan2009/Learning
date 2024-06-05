package com.learning.controller;

import com.learning.service.CustomerService;
import com.learning.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("/findAll")
    public List<Customer> findAllCustomers(){
        return service.findAllCustomers();
    }

    @GetMapping(value = "/findAll/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> findAllCustomersStream(){
        return service.findAllCustomersStream();
    }
}
