package com.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employer implements Person{
    private String name;
    private int age;
}
