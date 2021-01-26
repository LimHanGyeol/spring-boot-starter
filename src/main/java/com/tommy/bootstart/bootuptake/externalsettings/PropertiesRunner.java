package com.tommy.bootstart.bootuptake.externalsettings;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Section3. Spring Boot 활용
 * External Settings
 */
@Component
public class PropertiesRunner implements ApplicationRunner {

    private final HangyeolProperties hangyeolProperties;

    public PropertiesRunner(HangyeolProperties hangyeolProperties) {
        this.hangyeolProperties = hangyeolProperties;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("===Hangyeol Properties===");
        System.out.println(hangyeolProperties.getFullName());
        System.out.println(hangyeolProperties.getName());
        System.out.println(hangyeolProperties.getAge());
        System.out.println(hangyeolProperties.getSessionTimeout());
        System.out.println("=========================");
    }
}
