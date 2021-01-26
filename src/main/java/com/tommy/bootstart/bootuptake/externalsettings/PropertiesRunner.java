package com.tommy.bootstart.bootuptake.externalsettings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Section3. Spring Boot 활용
 * External Settings, Logging
 */
@Component
public class PropertiesRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(PropertiesRunner.class);

    private final HangyeolProperties hangyeolProperties;

    public PropertiesRunner(HangyeolProperties hangyeolProperties) {
        this.hangyeolProperties = hangyeolProperties;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("===Hangyeol Properties===");
        logger.debug(hangyeolProperties.getFullName());
        logger.debug(hangyeolProperties.getName());
        logger.debug(String.valueOf(hangyeolProperties.getAge()));
        logger.debug(String.valueOf(hangyeolProperties.getSessionTimeout()));
        logger.debug("=========================");
    }
}
