package com.tommy.bootstart.bootuptake.mvc.view;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Section3. Spring Boot 활용
 * Spring Web Mvc
 * Template Engine : Thymeleaf
 * HtmlUnit
 */
@WebMvcTest(ViewController.class)
class ViewControllerTest {

//    @Autowired
//    private MockMvc mockMvc;

    @Autowired
    private WebClient webClient;

    @Test
    @DisplayName("HtmlUnit 을 이용한 Ui Test")
    void view_htmlunit() throws IOException {
        HtmlPage page = webClient.getPage("/view");
        HtmlHeading1 h1 = page.getFirstByXPath("//h1");
        assertThat(h1.getTextContent()).isEqualTo("hangyeol");
    }

//    @Test
//    @DisplayName("Thymeleaf View Render Test(model test)")
//    void view_hello() throws Exception {
//        mockMvc.perform(get("/view"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("hello"))
//                .andExpect(model().attribute("name", is("hangyeol")))
//                .andExpect(xpath("//h1").string("hangyeol"))
//                .andExpect(content().string(containsString("hangyeol")))
//                .andDo(print());
//    }

}
