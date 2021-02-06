package com.tommy.bootstart.bootuptake.mvc.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 * Section3. Spring Boot 활용
 * Spring Web Mvc
 * HttpMessageConverter, ViewResolver
 */
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void hello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    void user_create_toJson() throws Exception {
        String userJson = "{\"username\":\"hangyeol\", \"password\":\"1234\"}";

        mockMvc.perform(post("/users")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .accept(MediaType.APPLICATION_JSON_VALUE)
                    .content(userJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username",
                        is(equalTo("hangyeol"))))
                .andExpect(jsonPath("$.password",
                        is(equalTo("1234"))));
    }

    @Test
    void user_create_toXml() throws Exception {
        String userJson = "{\"username\":\"hangyeol\", \"password\":\"1234\"}";

        mockMvc.perform(post("/users")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .accept(MediaType.APPLICATION_XML_VALUE)
                    .content(userJson))
                .andExpect(status().isCreated())
                .andExpect(xpath("/User/username")
                        .string("hangyeol"))
                .andExpect(xpath("/User/password")
                        .string("1234"))
                .andDo(print());
    }

}
