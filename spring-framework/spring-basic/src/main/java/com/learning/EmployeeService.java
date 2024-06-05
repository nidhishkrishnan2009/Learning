package com.learning;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private List<String> employeeList=List.of("Rahul","Raj","kean");

    public List<String> getAllEmployees(){
        return employeeList;
    }
}
