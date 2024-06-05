package com.learning.java9.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Person implements Serializable {
    private String name;
    private int age;
    //private transient BigDecimal salary;
    private BigDecimal salary;
}
