/*
 * Developed by Jason Choi on 18. 12. 14 오전 8:13.
 * Last modified 18. 12. 14 오전 8:13.
 * Copyright (c) 2018. All rights reserved.
 */

package me.jasonchoi.prac4.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import me.jasonchoi.prac4.model.JwtUser;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {
    private String secret = "JasonChoi";

    public JwtUser validate(String token) {

        JwtUser jwtUser = null;
        try
        {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();
            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            e.getMessage();
        }
        return jwtUser;
    }

}
