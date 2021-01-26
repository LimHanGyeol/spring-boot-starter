package com.tommy.bootstart.bootuptake.springapplication;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * Section3. Spring Boot 활용
 * SpringApplication
 * 어떤 Bean 의 생성자가 1개이고, 매개변수가 Bean 일 경우
 * 해당 Bean 을 스프링이 알아서 주입해준다.
 */
@Component
public class WebApplicationArgument {

    public WebApplicationArgument(ApplicationArguments arguments) {
        // Application 실행 시 -D 옵션 (JVM) 과 -- 옵션 (Arguments) 를 사용할 경우
        // -- 옵션만 사용이 된다.
        System.out.println("foo : " + arguments.containsOption("foo"));
        System.out.println("bar : " + arguments.containsOption("bar"));
    }
}
