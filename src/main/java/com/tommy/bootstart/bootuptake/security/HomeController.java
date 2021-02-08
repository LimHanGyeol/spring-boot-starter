package com.tommy.bootstart.bootuptake.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/open")
    public String open() {
        return "open";
    }

    @GetMapping("/my")
    public String my() {
        return "my";
    }
}
