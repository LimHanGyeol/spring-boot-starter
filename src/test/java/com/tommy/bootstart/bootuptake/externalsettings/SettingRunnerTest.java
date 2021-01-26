package com.tommy.bootstart.bootuptake.externalsettings;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest // (properties = "hangyeol.name=hangyeol2")
//@TestPropertySource(properties = "hangyeol.name=hangyeol3")
@TestPropertySource(locations = "classpath:/test.properties")
class SettingRunnerTest {

    @Autowired
    private Environment environment;

    @Test
    void properties_name() {
        assertThat(environment.getProperty("hangyeol.name"))
                .isEqualTo("test-hangyeol");
    }
}
