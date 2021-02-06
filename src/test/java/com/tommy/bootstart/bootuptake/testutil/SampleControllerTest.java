package com.tommy.bootstart.bootuptake.testutil;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Section3. Spring Boot 활용
 * Test
 * SpringBootTest-webEnvironment 의 기본값은 WebEnvironment.MOCK 이다.
 * RANDOM_PORT 를 이용하면 실제로 Servlet 이 구동된다. DEFINED_PORT 를 사용하면 지정한 포트를 사용한다.
 * RANDOM_PORT 를 권장한다.
 * 이때부터는 MockMvc 를 사용하는 것이 아닌 TestRestTemplate, TestWebClient 를 써야 한다.
 * 그러므로 TestRestTemplate 사용 시 @AutoConfigureMockMvc, MockMvc 를 사용하지 않는다.
 *
 * Service 단 까지 가지 않고 Controller 단으로만 테스트를 하고 싶으면 @MockBean 으로 의존성을 끊을 수 있다.
 * ApplicationContext 안에 들어있는 Bean 을 mockSampleService 로 교체한다.
 */
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestRestTemplate testRestTemplate;

    // RestClient 는 synchronize 이다. webClient 는 async 로 동작한다.
    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private SampleService mockSampleService;

    @Test
    void hello_mockMvc() throws Exception {
        // given
        given(mockSampleService.getName()).willReturn("hangyeol");

        mockMvc.perform(get("/holoman"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello hangyeol"))
                .andDo(print());
    }

    @Test
    void hello_testRestTemplate() {
        // given
        given(mockSampleService.getName()).willReturn("hangyeol");

        // when
        String result = testRestTemplate.getForObject("/holoman", String.class);

        // then
        assertThat(result).isEqualTo("Hello hangyeol");
    }

    @Test
    void hello_testWebClient() {
        when(mockSampleService.getName()).thenReturn("hangyeol");

        webTestClient.get()
                .uri("/holoman")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello hangyeol");
    }

    @Test
    void hello_mockController() {
        when(mockSampleService.getName()).thenReturn("hangyeol");

        String result = testRestTemplate.getForObject("/holoman", String.class);

        assertThat(result).isEqualTo("Hello hangyeol");
    }
}
