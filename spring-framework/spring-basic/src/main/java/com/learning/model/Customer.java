package com.learning.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
public class Customer implements Person {
    private String name;
    private int age;

    public Customer(String name,int age){
        this.name=name;
        this.age=age;
    }
}
