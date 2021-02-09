package com.tommy.bootstart.bootuptake.restclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestClientController {

    @GetMapping("/rest")
    public String rest() {
        return "rest";
    }

    @GetMapping("/client")
    public String client() {
        return "client";
    }
}
