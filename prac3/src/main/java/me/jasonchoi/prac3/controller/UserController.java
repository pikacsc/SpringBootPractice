/*
 * Developed by Jason Choi on 18. 12. 12 오전 8:56.
 * Last modified 18. 12. 12 오전 8:56.
 * Copyright (c) 2018. All rights reserved.
 */

package me.jasonchoi.prac3.controller;

import me.jasonchoi.prac3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model, @RequestParam(defaultValue = "") String name) {
        model.addAttribute("users",userService.findByName(name));
        return "views/list";
    }



}
