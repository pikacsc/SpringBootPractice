/*
 * Developed by Jason Choi on 18. 12. 14 오전 9:39.
 * Last modified 18. 12. 14 오전 9:39.
 * Copyright (c) 2018. All rights reserved.
 */

package me.jasonchoi.prac4.controller;

import me.jasonchoi.prac4.model.JwtUser;
import me.jasonchoi.prac4.security.JwtGenerator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {

    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser) {

         return jwtGenerator.generate(jwtUser);
    }

}
