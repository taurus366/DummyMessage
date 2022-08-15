package com.example.dummymessage.model.binding;

import com.example.dummymessage.model.enums.MessageType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TextBindingModel {

    @NotNull
    @Size(min = 1,max = 160,message = "the payload length should be between 1 and 160")
    private String payload;

    private final MessageType type = MessageType.TEXT;

    public String getPayload() {
        return payload;
    }

    public TextBindingModel setPayload(String payload) {
        this.payload = payload;
        return this;
    }

    public MessageType getType() {
        return type;
    }
}
