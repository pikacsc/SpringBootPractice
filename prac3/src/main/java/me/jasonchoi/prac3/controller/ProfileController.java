/*
 * Developed by Jason Choi on 18. 12. 13 오전 5:30.
 * Last modified 18. 12. 13 오전 5:30.
 * Copyright (c) 2018. All rights reserved.
 */

package me.jasonchoi.prac3.controller;

import me.jasonchoi.prac3.model.User;
import me.jasonchoi.prac3.service.TaskService;
import me.jasonchoi.prac3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal) {

        String email = principal.getName();
        User user = userService.findOne(email);
        model.addAttribute("tasks", taskService.findUserTask(user));


        return "views/profile";
    }


}
