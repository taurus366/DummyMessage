package com.example.dummymessage.web;

import com.example.dummymessage.model.binding.EmotionalBindingModel;
import com.example.dummymessage.model.binding.TextBindingModel;
import com.example.dummymessage.model.service.PayloadMessageServiceModel;
import com.example.dummymessage.service.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*") // to catch the server from everywhere
@RequestMapping("/messages")
public class MessageController {

    private MessageService messageService;
    private ModelMapper modelMapper;

    public MessageController(MessageService messageService, ModelMapper modelMapper) {
        this.messageService = messageService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/send_text")
    public ResponseEntity<Object> saveNewTextMessage(@Valid @RequestBody TextBindingModel textBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        return ObjectResponseEntity(bindingResult, textBindingModel);
    }

    @PostMapping("/send_emotional")
    public ResponseEntity<Object> saveNewEmotionalMessage(@Valid @RequestBody EmotionalBindingModel emotionalBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        return ObjectResponseEntity(bindingResult, emotionalBindingModel);
    }

    private <T> ResponseEntity<Object> ObjectResponseEntity(BindingResult bindingResult, @ModelAttribute @Valid T bindingModel) {
        if (bindingResult.hasErrors()) {

            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }

        PayloadMessageServiceModel mappedModel = modelMapper.map(bindingModel, PayloadMessageServiceModel.class);
        
        messageService
                .postNewMessage(mappedModel);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
