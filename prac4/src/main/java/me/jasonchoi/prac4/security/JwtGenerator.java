/*
 * Developed by Jason Choi on 18. 12. 14 오전 9:41.
 * Last modified 18. 12. 14 오전 9:41.
 * Copyright (c) 2018. All rights reserved.
 */

package me.jasonchoi.prac4.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import me.jasonchoi.prac4.model.JwtUser;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {
    public String generate(JwtUser jwtUser) {
        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUserName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());


        return Jwts.builder()
                .setClaims(claims)
                        .signWith(SignatureAlgorithm.HS512, "JasonChoi")
                        .compact();
    }
}
