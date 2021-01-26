package com.tommy.bootstart.bootuptake;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Section3. Spring Boot 활용
 * SpringApplication
 * Application 이 다 뜬 다음에 무엇인가를 추가로 실행하고 싶을 경우 사용
 * CommandLineRunner 도 있지만 해당 구현체는 run 의 매개변수가 가변인자이다.
 * ApplicationRunner 가 더 명확한 사용을 할 수 있다.
 */
@Component
public class AppRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=====Application Runner=====");
        System.out.println("foo : " + args.containsOption("foo"));
        System.out.println("bar : " + args.containsOption("bar"));
    }
}
