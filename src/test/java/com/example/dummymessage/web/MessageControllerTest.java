package com.example.dummymessage.web;

import com.example.dummymessage.service.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService mockMessageService;

    //    In case of send_text the payload length should be between 1 and 160
    @Test
    public void expectInvalidForSend_Text() throws Exception {

        mockMvc.perform(post("/messages/send_text")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content("{\"payload\":\"\"}"))
                .andExpect(status().is(412));
    }

    @Test
    public void expectValidForSend_Text() throws Exception {

        mockMvc.perform(post("/messages/send_text")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content("{\"payload\":\"test1234\"}"))
                .andExpect(status().is(201));
    }


//    In case of send_emotion the payload should be between 2 and 10 and should not contain characters
    @Test
    public void expectInvalidForSend_Emotional() throws Exception {

        mockMvc.perform(post("/messages/send_emotional")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content("{\"payload\":\"test1234\"}"))
                .andExpect(status().is(412));

    }

    @Test
    public void expectValidForSend_Emotional() throws Exception {

        mockMvc.perform(post("/messages/send_emotional")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content("{\"payload\":\"3\"}"))
                .andExpect(status().is(201));
    }
}
