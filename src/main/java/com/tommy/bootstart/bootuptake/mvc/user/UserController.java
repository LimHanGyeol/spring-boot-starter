package com.tommy.bootstart.bootuptake.mvc.user;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Section3. Spring Boot 활용
 * Spring Web Mvc
 * HttpMessageConverter, RestApi HATEOAS
 */
@RestController
public class UserController {

    @GetMapping("/hello")
    public ResponseEntity<EntityModel<Hello>> hello() {
        Hello hello = new Hello("hey,","hangyeol" );

        EntityModel<Hello> helloEntityModel = EntityModel.of(hello);
        helloEntityModel.add(linkTo(methodOn(UserController.class).hello()).withSelfRel());

        return ResponseEntity.ok().body(helloEntityModel);
    }

    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
