package com.components;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComponentScanTest {

    @GetMapping("/componentScan")
    public String testComponentScan(){
        return "testing component scan";
    }
}
