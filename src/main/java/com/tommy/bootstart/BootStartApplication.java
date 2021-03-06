package com.tommy.bootstart;

import com.tommy.bootstart.bootuptake.springapplication.EventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BootStartApplication {

    public static void main(String[] args) {
        // Application 시작 전에 EventListener 가 필요한 경우 직접 코드를 이용하여 적용한다.
        // WebApplication 에서 WebMvc 의존성이 적용되었을 경우 Type의 기본값은 Servlet 이다.
        SpringApplication app = new SpringApplication(BootStartApplication.class);
        app.addListeners(new EventListener());
        app.setWebApplicationType(WebApplicationType.SERVLET);
        app.run(args);
    }

    // 전역적인 WebClient 커스터마이징
    @Bean
    public WebClientCustomizer webClientCustomizer() {
        return webClientBuilder -> webClientBuilder.baseUrl("http://localhost:8080");
    }

    // 전역적인 RestTemplate 커스터마이징
    @Bean
    public RestTemplateCustomizer restTemplateCustomizer() {
        return restTemplate -> restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
    }

}
