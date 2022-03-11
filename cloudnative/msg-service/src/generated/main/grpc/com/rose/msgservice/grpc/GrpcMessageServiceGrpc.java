package com.rose.msgservice.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.44.1)",
    comments = "Source: grpcmessage.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GrpcMessageServiceGrpc {

  private GrpcMessageServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.GrpcMessageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.rose.msgservice.grpc.GrpcMessageReq,
      com.rose.msgservice.grpc.GrpcMessage> getGetAllMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllMessages",
      requestType = com.rose.msgservice.grpc.GrpcMessageReq.class,
      responseType = com.rose.msgservice.grpc.GrpcMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rose.msgservice.grpc.GrpcMessageReq,
      com.rose.msgservice.grpc.GrpcMessage> getGetAllMessagesMethod() {
    io.grpc.MethodDescriptor<com.rose.msgservice.grpc.GrpcMessageReq, com.rose.msgservice.grpc.GrpcMessage> getGetAllMessagesMethod;
    if ((getGetAllMessagesMethod = GrpcMessageServiceGrpc.getGetAllMessagesMethod) == null) {
      synchronized (GrpcMessageServiceGrpc.class) {
        if ((getGetAllMessagesMethod = GrpcMessageServiceGrpc.getGetAllMessagesMethod) == null) {
          GrpcMessageServiceGrpc.getGetAllMessagesMethod = getGetAllMessagesMethod =
              io.grpc.MethodDescriptor.<com.rose.msgservice.grpc.GrpcMessageReq, com.rose.msgservice.grpc.GrpcMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllMessages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rose.msgservice.grpc.GrpcMessageReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rose.msgservice.grpc.GrpcMessage.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcMessageServiceMethodDescriptorSupplier("GetAllMessages"))
              .build();
        }
      }
    }
    return getGetAllMessagesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GrpcMessageServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcMessageServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcMessageServiceStub>() {
        @java.lang.Override
        public GrpcMessageServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcMessageServiceStub(channel, callOptions);
        }
      };
    return GrpcMessageServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrpcMessageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcMessageServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcMessageServiceBlockingStub>() {
        @java.lang.Override
        public GrpcMessageServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcMessageServiceBlockingStub(channel, callOptions);
        }
      };
    return GrpcMessageServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GrpcMessageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcMessageServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcMessageServiceFutureStub>() {
        @java.lang.Override
        public GrpcMessageServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcMessageServiceFutureStub(channel, callOptions);
        }
      };
    return GrpcMessageServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GrpcMessageServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAllMessages(com.rose.msgservice.grpc.GrpcMessageReq request,
        io.grpc.stub.StreamObserver<com.rose.msgservice.grpc.GrpcMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllMessagesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAllMessagesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.rose.msgservice.grpc.GrpcMessageReq,
                com.rose.msgservice.grpc.GrpcMessage>(
                  this, METHODID_GET_ALL_MESSAGES)))
          .build();
    }
  }

  /**
   */
  public static final class GrpcMessageServiceStub extends io.grpc.stub.AbstractAsyncStub<GrpcMessageServiceStub> {
    private GrpcMessageServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcMessageServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcMessageServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAllMessages(com.rose.msgservice.grpc.GrpcMessageReq request,
        io.grpc.stub.StreamObserver<com.rose.msgservice.grpc.GrpcMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllMessagesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GrpcMessageServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GrpcMessageServiceBlockingStub> {
    private GrpcMessageServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcMessageServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcMessageServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.rose.msgservice.grpc.GrpcMessage getAllMessages(com.rose.msgservice.grpc.GrpcMessageReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllMessagesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GrpcMessageServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GrpcMessageServiceFutureStub> {
    private GrpcMessageServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcMessageServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcMessageServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rose.msgservice.grpc.GrpcMessage> getAllMessages(
        com.rose.msgservice.grpc.GrpcMessageReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllMessagesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_MESSAGES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GrpcMessageServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GrpcMessageServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL_MESSAGES:
          serviceImpl.getAllMessages((com.rose.msgservice.grpc.GrpcMessageReq) request,
              (io.grpc.stub.StreamObserver<com.rose.msgservice.grpc.GrpcMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GrpcMessageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GrpcMessageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.rose.msgservice.grpc.CoreGrpcMsgApi.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GrpcMessageService");
    }
  }

  private static final class GrpcMessageServiceFileDescriptorSupplier
      extends GrpcMessageServiceBaseDescriptorSupplier {
    GrpcMessageServiceFileDescriptorSupplier() {}
  }

  private static final class GrpcMessageServiceMethodDescriptorSupplier
      extends GrpcMessageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GrpcMessageServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GrpcMessageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GrpcMessageServiceFileDescriptorSupplier())
              .addMethod(getGetAllMessagesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
