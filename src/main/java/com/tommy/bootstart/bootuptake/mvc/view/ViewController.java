package com.tommy.bootstart.bootuptake.mvc.view;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Section3. Spring Boot 활용
 * Spring Web Mvc
 * Template Engine : Thymeleaf, ExceptionHandler
 */
@Controller
public class ViewController {

    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("name", "hangyeol");
        return "hello";
    }

    @GetMapping("/exception")
    public String exception() {
        throw new SampleException();
    }

//    500 error 확인하기 위해 주석 처리
//    @ExceptionHandler(SampleException.class)
//    @ResponseBody
//    public AppError sampleError(SampleException e) {
//        return new AppError("error.app.key", "invalid SDK");
//    }

}
