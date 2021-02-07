package com.tommy.bootstart.bootuptake.mvc.user;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Section3. Spring Boot 활용
 * Spring Web Mvc
 * HttpMessageConverter, RestApi HATEOAS, CORS
 * HATEOAS 의 사용방법이 많이 바뀌었다. 실 적용할때는 공식 레퍼런스를 잘 보고 도입해야 할 것 같다.
 */
@RestController
// @CrossOrigin(origins = "http://localhost:8081") // WebConfig 파일에서 공통적으로 관리할 수 있다.
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

    @GetMapping("/cors")
    public String cors() {
        return "cors server";
    }

}
