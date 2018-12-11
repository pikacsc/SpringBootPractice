/*
 * Developed by Jason Choi on 18. 12. 12 오전 7:21.
 * Last modified 18. 12. 12 오전 7:21.
 * Copyright (c) 2018. All rights reserved.
 */

package me.jasonchoi.prac3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String showIndexPage() {
        return "index";
    }

}
