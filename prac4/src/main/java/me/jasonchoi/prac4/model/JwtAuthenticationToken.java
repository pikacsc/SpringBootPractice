/*
 * Developed by Jason Choi on 18. 12. 14 오전 8:06.
 * Last modified 18. 12. 14 오전 8:06.
 * Copyright (c) 2018. All rights reserved.
 */

package me.jasonchoi.prac4.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {


    private String token;

    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
