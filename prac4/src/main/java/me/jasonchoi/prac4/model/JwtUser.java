/*
 * Developed by Jason Choi on 18. 12. 14 오전 8:34.
 * Last modified 18. 12. 14 오전 8:34.
 * Copyright (c) 2018. All rights reserved.
 */

package me.jasonchoi.prac4.model;

public class JwtUser {

    private String userName;

    private Long id;

    private String role;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
