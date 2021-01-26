package com.tommy.bootstart.bootuptake.testutil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Section3. Spring Boot 활용
 * Test
 */
@RestController
public class SampleController {

    Logger logger = LoggerFactory.getLogger(SampleController.class);

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/hello")
    public String hello() {
        logger.info("holoman");
        return "Hello " + sampleService.getName();
    }

}
