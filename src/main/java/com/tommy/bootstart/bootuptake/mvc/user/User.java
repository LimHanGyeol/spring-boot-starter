package com.tommy.bootstart.bootuptake.mvc.user;

/**
 * Section3. Spring Boot 활용
 * Spring Web Mvc
 */
public class User {

    private Long id;
    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
