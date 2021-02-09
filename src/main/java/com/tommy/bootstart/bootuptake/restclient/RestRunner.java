package com.tommy.bootstart.bootuptake.restclient;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Section3. Spring Boot 활용
 * Rest Client - RestTemplate, WebClient
 */
@Component
public class RestRunner implements ApplicationRunner {

    private final WebClient.Builder builder;
    private final RestTemplateBuilder restTemplateBuilder;

    public RestRunner(WebClient.Builder builder, RestTemplateBuilder restTemplateBuilder) {
        this.builder = builder;
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("-------RestClient-------");
//        RestTemplate restTemplate = restTemplateBuilder.build();
        // 지역적인 WebClient 커스터마이징
        WebClient webClient = builder
//                .baseUrl("http://localhost:8080")
                .build();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

//        String restResult = restTemplate.getForObject("http://localhost:8080/rest", String.class);
        Mono<String> restResult = webClient.get().uri("/rest")
                .retrieve()
                .bodyToMono(String.class);
        restResult.subscribe(result -> {
            System.out.println(result);

            if (stopWatch.isRunning()) {
                stopWatch.stop();
            }

            System.out.println(stopWatch.prettyPrint());
            stopWatch.start();
        });

//        String clientResult = restTemplate.getForObject("http://localhost:8080/client", String.class);
        Mono<String> clientResult = webClient.get().uri("/client")
                .retrieve()
                .bodyToMono(String.class);
        clientResult.subscribe(result -> {
            System.out.println(result);

            if (stopWatch.isRunning()) {
                stopWatch.stop();
            }

            System.out.println(stopWatch.prettyPrint());
        });

    }
}
