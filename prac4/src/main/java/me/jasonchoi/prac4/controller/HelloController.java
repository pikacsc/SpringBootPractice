/*
 * Developed by Jason Choi on 18. 12. 14 오전 7:33.
 * Last modified 18. 12. 14 오전 7:33.
 * Copyright (c) 2018. All rights reserved.
 */

package me.jasonchoi.prac4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello World";
    }
}
