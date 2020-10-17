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

    @Autowired
    private MockMvc mockMvc;

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






    @Test
    void addUser() throws Exception {
        this.mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON).header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjAyODk4OTMyLCJleHAiOjE2MDI4OTk1MzJ9.aI_qib1X_-UpPIWCibR-Iy5eDBbLCdS4vSG7d_s2KbLIYGNO3zr7enBqEgL3ARYU5zzD6P4ujD26xzVj4lfGbg")
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
                .andExpect(content().string(containsString("{\n" +
                        "    \"id\": \"7d66c9c5-2ffc-4cec-8435-75f8d60f44fe\",\n" +
                        "    \"created\": \"2020-10-16 22:42:38.72\",\n" +
                        "    \"modified\": null,\n" +
                        "    \"last_login\": \"2020-10-16 22:42:38.72\",\n" +
                        "    \"token\": \"Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiSnVhbiBSb2RyaWd1ZXoiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjAyODk4OTU4LCJleHAiOjE2MDI4OTk1NTh9.qK3IClnHu-dJnWyY0Tz3tS61xpicJ6oqSo-Osjce_b7k3ddAWc_zBfHRUl3oKgr5-zBrGIr1hXGAA2KYozusxA\",\n" +
                        "    \"isactive\": true\n" +
                        "}")));
    }
}