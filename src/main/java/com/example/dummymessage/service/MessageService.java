package com.example.dummymessage.service;

import com.example.dummymessage.model.entity.MessageEntity;
import com.example.dummymessage.model.service.PayloadMessageServiceModel;

public interface MessageService {

    MessageEntity postNewMessage(PayloadMessageServiceModel payload);
}
