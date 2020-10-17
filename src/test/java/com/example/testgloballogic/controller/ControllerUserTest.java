package com.example.testgloballogic.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerUserTest {

    @Test
    void login()throws Exception {
        this.mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"admin\",\n" +
                        "    \"email\": \"juan@rodriguez.org\",\n" +
                        "    \"password\": \"Admin123\",\n" +
                        "    \"phones\": [\n" +
                        "        {\n" +
                        "            \"number\": \"1234567\",\n" +
                        "            \"citycode\": \"1\",\n" +
                        "            \"contrycode\": \"57\"\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Bearer eyJhbGciOiJIUzUxMiJ9")));

    }


    @Autowired
    private MockMvc mockMvc;



    @Test
    void addUser() {

    }
}