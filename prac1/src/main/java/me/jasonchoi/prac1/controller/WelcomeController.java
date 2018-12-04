package me.jasonchoi.prac1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


    @RequestMapping("/")
    public String home() {
        return "Hello Welcome to Spring boot!";
    }

}
