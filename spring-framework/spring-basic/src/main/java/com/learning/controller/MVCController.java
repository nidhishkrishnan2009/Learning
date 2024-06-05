package com.learning.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MVCController {
    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/home")
    public String homePage(Model model){
        model.addAttribute("appName",appName);
        return "home";
    }
}
