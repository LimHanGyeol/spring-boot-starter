package com.tommy.bootstart.bootuptake.testutil;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Section3. Spring Boot 활용
 * Test
 * WebMvcTest 를 이용한 슬라이스 테스트 Web 관련된 Bean 만 가지고 오게 된다.
 */
@WebMvcTest(SampleController.class)
public class SampleWebMvcTest {

    @MockBean
    private SampleService mockSampleService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("hangyeol");

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello hangyeol"));
    }
}
