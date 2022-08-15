package com.example.dummymessage.model.service;

import com.example.dummymessage.model.enums.MessageType;

public class PayloadMessageServiceModel {


    private String payload;

    private MessageType type;

    public MessageType getType() {
        return type;
    }

    public PayloadMessageServiceModel setType(MessageType type) {
        this.type = type;
        return this;
    }

    public String getPayload() {
        return payload;
    }

    public PayloadMessageServiceModel setPayload(String payload) {
        this.payload = payload;
        return this;
    }
}
