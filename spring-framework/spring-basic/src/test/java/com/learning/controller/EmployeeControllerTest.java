package com.learning.controller;

import com.learning.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class EmployeeControllerTest {

    @Autowired
    private EmployeeService employeeService;

    @DisplayName("Test getting all employees")
    @Test
    public void testGetEmployeeList(){
        assertEquals(3,employeeService.getAllEmployees().size());
    }
}
