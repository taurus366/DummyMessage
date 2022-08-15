package com.example.dummymessage.service.impl;

import com.example.dummymessage.model.entity.MessageEntity;
import com.example.dummymessage.model.service.PayloadMessageServiceModel;
import com.example.dummymessage.repository.MessageRepository;
import com.example.dummymessage.service.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;
    private ModelMapper modelMapper;

    public MessageServiceImpl(MessageRepository messageRepository, ModelMapper modelMapper) {
        this.messageRepository = messageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MessageEntity postNewMessage(PayloadMessageServiceModel payload) {

        MessageEntity newMessage = new MessageEntity();

        MessageEntity mapped = modelMapper.map(payload, MessageEntity.class);

        return messageRepository.save(mapped);
    }
}
