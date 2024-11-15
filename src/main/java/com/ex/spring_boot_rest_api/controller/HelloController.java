package com.ex.spring_boot_rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // HTTP GET Request
    // localhost:8080/greeting
    @GetMapping("/greeting")
    public String greeting(){
        return "Hello World!";
    }
}
