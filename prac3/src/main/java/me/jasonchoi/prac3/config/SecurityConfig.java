/*
 * Developed by Jason Choi on 18. 12. 13 오전 5:40.
 * Last modified 18. 12. 13 오전 5:40.
 * Copyright (c) 2018. All rights reserved.
 */

package me.jasonchoi.prac3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select email as principal, password as credentials, true from user where email = ?")
                .authoritiesByUsernameQuery("select user_email as principal, role_name as role from user_roles where user_email = ?")
                .passwordEncoder(passwordEncoder()).rolePrefix("ROLE_");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/URL").permitAll() //access permit to all, Everyone can access that /URL
                .antMatchers("/register","/","/about","login","/css/**","/webjars/**").permitAll()

                //.antMatchers("/URL").hasAnyRole("A,B") //access permit to ROLE named A or B
                .antMatchers("/profile").hasAnyRole("USER, ADMIN")

                //.antMatchers("/URL").hasRole("A") //access permit to ROLE named A only
                .antMatchers("/users","/addTask").hasRole("ADMIN")

                .and().formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/profile").and().logout().logoutSuccessUrl("/login");
    }
}
