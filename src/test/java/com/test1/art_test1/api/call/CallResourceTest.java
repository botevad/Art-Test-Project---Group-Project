package com.test1.art_test1.api.call;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test1.art_test1.Credentials;
import com.test1.art_test1.api.sms.SmsDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CallResourceTest {

    @Autowired
    MockMvc mockMvc;
    private NamedParameterJdbcOperations namedTemplate;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getCallStatus() throws Exception {
        Credentials c = new Credentials();
        c.setUserName("admin");
        c.setUserPass("pass");
        String id = "381";

        final String token = mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(c)))
                .andExpect(header().exists("X-AUTH-TOKEN"))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getHeader("X-AUTH-TOKEN");

        mockMvc.perform(get("/svc/call")
                .param("id", id)
                .header("X-AUTH-TOKEN", token))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void getAllUserCall() throws Exception {
        Credentials c = new Credentials();
        c.setUserName("admin");
        c.setUserPass("pass");
        String username = "admin";

        final String token = mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(c)))
                .andExpect(header().exists("X-AUTH-TOKEN"))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getHeader("X-AUTH-TOKEN");

        mockMvc.perform(get("/svc/call/user")
                .param("username", username)
                .header("X-AUTH-TOKEN", token))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void createCall() throws Exception {
        Credentials c = new Credentials();
        c.setUserName("admin");
        c.setUserPass("pass");
        String username = "admin";

        final String token = mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(c)))
                .andExpect(header().exists("X-AUTH-TOKEN"))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getHeader("X-AUTH-TOKEN");

        mockMvc.perform(get("/svc/call/user")
                .param("username", username)
                .header("X-AUTH-TOKEN", token))
                .andExpect(status().isOk())
                .andDo(print());
    }
}