package com.tommy.bootstart.bootuptake.mvc.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Section3. Spring Boot 활용
 * Spring Web Mvc
 * HttpMessageConverter
 */
@RestController
public class UserController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
