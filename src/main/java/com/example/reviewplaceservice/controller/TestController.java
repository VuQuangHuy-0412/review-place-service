package com.example.reviewplaceservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/ping")
    public String ping() {
        return "ping 200 ok";
    }
}
