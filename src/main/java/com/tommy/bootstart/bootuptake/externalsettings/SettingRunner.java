package com.tommy.bootstart.bootuptake.externalsettings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Section3. Spring Boot 활용
 * External Settings
 */
@Component
public class SettingRunner implements ApplicationRunner {

    @Value("${hangyeol.name}")
    private String name;

    @Value("${hangyeol.fullName}")
    private String fullName;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("======Properties======");
        System.out.println(fullName);
        System.out.println(name);
        System.out.println("======================");
    }
}
