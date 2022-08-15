package com.example.dummymessage.service;


import com.example.dummymessage.model.entity.MessageEntity;
import com.example.dummymessage.model.enums.MessageType;
import com.example.dummymessage.model.service.PayloadMessageServiceModel;
import com.example.dummymessage.repository.MessageRepository;
import com.example.dummymessage.service.impl.MessageServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
public class MessageServiceTest {


    private MessageEntity messageEntity;
    private MessageService messageService;

    private PayloadMessageServiceModel serviceModel;
    @Mock
    private MessageRepository mockMessageRepository;

    @Mock
    private ModelMapper mockModelMapper;

    @BeforeEach
     void init() {
        messageEntity = new MessageEntity();
        messageEntity
                .setPayload("test1234")
                .setType(MessageType.TEXT);

        serviceModel = new PayloadMessageServiceModel();
        serviceModel
                .setPayload("test1234")
                .setType(MessageType.TEXT);

        Mockito.when(mockMessageRepository.save(messageEntity)).thenReturn(messageEntity);
        Mockito.when(mockModelMapper.map(serviceModel,MessageEntity.class)).thenReturn(messageEntity);

        messageService = new MessageServiceImpl(mockMessageRepository, mockModelMapper);
    }

    @Test
    public void expectServicePostNewWorks() {

        MessageEntity messageEntity1 = messageService.postNewMessage(serviceModel);

        Assertions.assertEquals(messageEntity.getPayload(), messageEntity1.getPayload());
    }

}
