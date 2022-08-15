package com.example.dummymessage.model.binding;

import com.example.dummymessage.model.enums.MessageType;
import com.example.dummymessage.model.validator.IsContainsCharacter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmotionalBindingModel {

    @NotNull
//    @Size(min = 2,max = 10,message = "the payload should be between 2 and 10 and should not contain characters")
    @Min(2)
    @Max(10)
    @IsContainsCharacter()
    private String payload;

    private final MessageType type = MessageType.EMOTION;

    public String getPayload() {
        return payload;
    }

    public EmotionalBindingModel setPayload(String payload) {
        this.payload = payload;
        return this;
    }

    public MessageType getType() {
        return type;
    }
}
