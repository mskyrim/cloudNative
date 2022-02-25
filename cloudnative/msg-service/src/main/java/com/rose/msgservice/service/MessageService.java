package com.rose.msgservice.service;

import com.rose.msgservice.dto.MessageDTO;

import java.util.List;

public interface MessageService {
    MessageDTO save(MessageDTO messageDTO);

    MessageDTO getMessage(String id) throws MessageServiceException;

    List<MessageDTO> allMessages();

    void publishMsgCreationEvent(String msgId);
}
