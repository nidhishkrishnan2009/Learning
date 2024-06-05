package com.components;

import com.learning.model.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean("customer")
    public Customer getCustomer(){
        return new Customer("Raj",21);
    }
}
