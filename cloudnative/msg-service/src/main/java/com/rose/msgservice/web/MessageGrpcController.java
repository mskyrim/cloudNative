package com.rose.msgservice.web;

import com.rose.msgservice.grpc.GrpcMessageServiceGrpc;
import com.rose.msgservice.service.MessageServiceGrpc;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class MessageGrpcController extends GrpcMessageServiceGrpc.GrpcMessageServiceImplBase {
    private final MessageServiceGrpc messageServiceGrpc;

    public MessageGrpcController(MessageServiceGrpc messageServiceGrpc) {
        this.messageServiceGrpc = messageServiceGrpc;
    }


    @Override
    public void getAllMessages(com.rose.msgservice.grpc.GrpcMessageReq request,
                               io.grpc.stub.StreamObserver<com.rose.msgservice.grpc.GrpcMessage> responseObserver) {
        responseObserver.onNext(this.messageServiceGrpc.getOneMessage());
        responseObserver.onCompleted();
    }

}
