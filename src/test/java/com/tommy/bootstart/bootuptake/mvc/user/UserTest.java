package com.tommy.bootstart.bootuptake.mvc.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Section3. Spring Boot 활용
 * Spring Web Mvc
 */
class UserTest {

    @Test
    void user_create() {
        User user = new User("hangyeol", "1234");
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("hangyeol");
        assertThat(user.getPassword()).isEqualTo("1234");
    }

}
