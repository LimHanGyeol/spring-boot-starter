package com.tommy.bootstart.bootuptake.mvc.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Section3. Spring Boot 활용
 * Spring Web Mvc
 * Template Engine : Thymeleaf
 */
@Controller
public class ViewController {

    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("name", "hangyeol");
        return "hello";
    }

}
