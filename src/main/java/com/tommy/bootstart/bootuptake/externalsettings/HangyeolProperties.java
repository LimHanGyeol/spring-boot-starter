package com.tommy.bootstart.bootuptake.externalsettings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.Duration;

/**
 * Section3. Spring Boot 활용
 * External Settings
 * Properties 에 중복되는 key 가 있을 경우
 * spring-boot-configuration-processor 로 Type-safe 하게 만들 수 있다.
 * validation 의존성을 통해 Properties Value 들을 검증할 수 있다.
 */
@Component
@ConfigurationProperties("hangyeol")
@Validated
public class HangyeolProperties {

    @NotEmpty
    private String name;

    private String fullName;

    @Min(0) @Max(30)
    private int age;

    private Duration sessionTimeout = Duration.ofSeconds(30);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Duration getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Duration sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }
}
