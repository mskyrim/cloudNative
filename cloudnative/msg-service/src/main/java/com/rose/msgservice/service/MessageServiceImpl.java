package com.rose.msgservice.service;

import com.rose.msgservice.dao.MessageRepository;
import com.rose.msgservice.dto.MsgEvent;
import com.rose.msgservice.dto.MessageDTO;
import com.rose.msgservice.mapper.MessageMapper;
import com.rose.msgservice.model.Message;
import com.rose.msgservice.restclient.EventClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    private MessageMapper messageMapper;
    private MessageRepository messageRepository;
    private EventClient eventClient;

    public static final String ACTOR = "MessageService";

    public MessageServiceImpl(MessageMapper messageMapper, MessageRepository messageRepository, EventClient eventClient) {
        this.messageMapper = messageMapper;
        this.messageRepository = messageRepository;
        this.eventClient = eventClient;
    }

    @Override
    public MessageDTO save(MessageDTO messageDTO) {
        Message message = messageMapper.messageDtoToMessage(messageDTO);
        message.setId(UUID.randomUUID().toString());
        Message savedMessage = messageRepository.save(message);
        publishMsgCreationEvent(savedMessage.getId());
        return messageMapper.messageToMessageDto(savedMessage);
    }

    @Override
    public MessageDTO getMessage(String id) throws MessageServiceException {
        Message message = messageRepository.findById(id).orElseThrow(() -> new MessageServiceException("no message found"));
        return messageMapper.messageToMessageDto(message);
    }

    @Override
    public List<MessageDTO> allMessages() {
        List<Message> messageList = messageRepository.findAll();
        return messageList.stream().map(message -> messageMapper.messageToMessageDto(message)).collect(Collectors.toList());
    }

    @Override
    public void publishMsgCreationEvent(String msgId) {
            MsgEvent msgEvent = new MsgEvent();
            msgEvent.setMsgId(msgId);
            msgEvent.setActor(ACTOR);
            msgEvent.setDescription("Message created");
            msgEvent.setDate(LocalDateTime.now().toString());
            this.eventClient.create(msgEvent);
    }
}
