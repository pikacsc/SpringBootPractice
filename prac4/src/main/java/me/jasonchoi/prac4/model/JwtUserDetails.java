/*
 * Developed by Jason Choi on 18. 12. 14 오전 9:04.
 * Last modified 18. 12. 14 오전 9:04. 
 * Copyright (c) 2018. All rights reserved.
 */

package me.jasonchoi.prac4.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class JwtUserDetails implements UserDetails {


    private String userName;
    private String token;
    private Long id;
    private Collection<? extends GrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return userName;
    }


    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUserName() {
        return userName;
    }



    public String getToken() {
        return token;
    }

    public Long getId() {
        return id;
    }


    public JwtUserDetails(String userName, Long id, String token, List<GrantedAuthority> grantedAuthorities) {
        this.userName = userName;
        this.id = id;
        this.token = token;
        this.authorities = grantedAuthorities;
    }
}
