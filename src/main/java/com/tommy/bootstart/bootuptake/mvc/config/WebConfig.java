package com.tommy.bootstart.bootuptake.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Section3. Spring Boot 활용
 * Spring Web Mvc
 * ResourceHandler, CORS
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/m/**")
                .addResourceLocations("classpath:/m/")
                .setCachePeriod(20);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/cors") // 전역 : /**
                .allowedOrigins("http://localhost:8081");
    }
}
