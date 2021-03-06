package com.aduno.randomlog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RandomLogApiTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogEmitter logEmitter;


    @Test
    public void createRandomLog() throws Exception {
        mockMvc.perform(post("/logs")).andExpect(status().isOk());
        then(logEmitter).should().randomLog();
    }

    @Test
    public void createCustomLog() throws Exception {
        String expectedMessage = UUID.randomUUID().toString();
        mockMvc.perform(post("/logs").param("message", expectedMessage)).andExpect(status().isOk());
        then(logEmitter).should().log(Level.INFO, expectedMessage);
    }

}
