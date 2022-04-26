package com.rose.msgservice.web;

import com.rose.msgservice.dto.MessageDTO;
import com.rose.msgservice.service.MessageService;
import com.rose.msgservice.service.MessageServiceException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "message")
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public MessageDTO save(@RequestBody MessageDTO messageDTO) {
        return messageService.save(messageDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MessageDTO> getAllMessages() {
        return messageService.allMessages();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageDTO getMessages(@PathVariable String id) throws MessageServiceException {
        return messageService.getMessage(id);
    }
}
