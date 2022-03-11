package com.rose.msgservice.service;

import com.rose.msgservice.grpc.GrpcMessage;

import java.util.List;

public interface MessageServiceGrpc {

    List<GrpcMessage> allMessages();

    GrpcMessage getOneMessage();

}
