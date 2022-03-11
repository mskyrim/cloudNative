package com.rose.msgservice.service;

import com.rose.msgservice.dao.MessageRepository;
import com.rose.msgservice.grpc.GrpcMessage;
import com.rose.msgservice.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageServiceGrpcImpl implements MessageServiceGrpc{
    private static Logger logger = LoggerFactory.getLogger(MessageServiceGrpcImpl.class);
    private final MessageRepository messageRepository;

    public MessageServiceGrpcImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<GrpcMessage> allMessages() {
        logger.info("Call of Service GRPC");
        final List<Message> messages = this.messageRepository.findAll();
        final List<GrpcMessage> grpcMessages = messages.stream().map(msg -> GrpcMessage.newBuilder()
                .setSystemId(msg.getSystemId())
                .setBody(msg.getBody()).build()).toList();
        return grpcMessages;
    }

    @Override
    public GrpcMessage getOneMessage() {
        logger.info("Call of Service GRPC");
        final List<Message> messages = this.messageRepository.findAll();
        final List<GrpcMessage> grpcMessages = messages.stream().map(msg -> GrpcMessage.newBuilder()
                .setSystemId(msg.getSystemId())
                .setBody(msg.getBody()).build()).toList();
        return (grpcMessages.isEmpty() ? null : grpcMessages.get(0));
    }
}
