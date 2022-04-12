package com.webservice.study.web;

import net.bytebuddy.matcher.ElementMatchers;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.MockMvcResultMatchersDsl.*;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("한번해보는 헬로우 테스트 Junit4")
    public void hello() throws  Exception{
        String hello = "hello";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    /**
     * jsonPath -> 1) JSON 응답값을 필드별로 검증할 수 있는 메소드입니다. 2) $를 기준으로 필드명으로 명시합니다.
     *
     * @throws Exception
     */
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mockMvc.perform(MockMvcRequestBuilders.get("/hello/dto")
                .param("name",name) // API 테스트 할 때 사용될 요청 파라미터를 설정합니다.
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", IsEqual.equalTo(name)))  //String만 가능 그래서 숫자/날짜 등의 데이터
                .andExpect(jsonPath("$.amount", IsEqual.equalTo(amount)));

    }





}