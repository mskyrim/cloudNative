package com.rose.msgservice.web;

import com.rose.msgservice.ping.GrpcPingServiceGrpc;
import com.rose.msgservice.ping.PingRequest;
import com.rose.msgservice.ping.PingResponse;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class PingGrpcController extends GrpcPingServiceGrpc.GrpcPingServiceImplBase {

    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {
        responseObserver.onNext(PingResponse.newBuilder().setMessage("your gRPC ping message " + request.getMessage() + " is received correctly")
                .build());
        responseObserver.onCompleted();
    }
}
