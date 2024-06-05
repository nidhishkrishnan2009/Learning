package com.learning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {
    @GetMapping("/say-hello")
    public String sayHello(){
        return "hello from docker controller";
    }
}
