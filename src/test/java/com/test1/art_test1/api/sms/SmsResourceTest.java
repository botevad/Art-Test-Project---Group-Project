package com.test1.art_test1.api.sms;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test1.art_test1.Credentials;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;


import java.sql.SQLException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SmsResourceTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void testGetSmsStatus() throws Exception {
        Credentials c = new Credentials();
        c.setUserName("admin");
        c.setUserPass("pass");
        String id = "261";

        final String token = mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(c)))
                .andExpect(header().exists("X-AUTH-TOKEN"))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getHeader("X-AUTH-TOKEN");

        mockMvc.perform(get("/svc/sms")
                .param("id", id)
                .header("X-AUTH-TOKEN", token))
                .andExpect(status().isOk())
                .andDo(print());

    }


    @Test
    public void testGetSms() throws Exception {
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

        mockMvc.perform(get("/svc/sms/user")
                .param("username", username)
                .header("X-AUTH-TOKEN", token))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testCreateSms() throws Exception {
        Credentials c = new Credentials();
        c.setUserName("admin");
        c.setUserPass("pass");
        String id = "261";

        final String token = mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(c)))
                .andExpect(header().exists("X-AUTH-TOKEN"))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getHeader("X-AUTH-TOKEN");

        mockMvc.perform(get("/svc/sms/user")
                .header("X-AUTH-TOKEN", token))
                .andExpect(status().isOk())
                .andDo(print());
    }
}