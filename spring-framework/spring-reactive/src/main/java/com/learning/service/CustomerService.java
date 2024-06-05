package com.learning.service;

import com.learning.dao.CustomerDao;
import com.learning.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@Slf4j
public class CustomerService {
    @Autowired
    private CustomerDao dao;

    public List<Customer> findAllCustomers(){
        long start=System.currentTimeMillis();
        List<Customer> allCustomers = dao.findAllCustomers();
        long end=System.currentTimeMillis();
        log.info("Total Execution time = {}ms",end-start);
        return allCustomers;
    }

    public Flux<Customer> findAllCustomersStream(){
        long start=System.currentTimeMillis();
        Flux<Customer> allCustomers = dao.findAllCustomersStream();
        long end=System.currentTimeMillis();
        log.info("Total Execution time = {}ms",end-start);
        return allCustomers;
    }
}
