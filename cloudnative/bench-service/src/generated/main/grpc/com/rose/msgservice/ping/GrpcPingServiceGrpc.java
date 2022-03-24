package com.rose.msgservice.ping;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.44.1)",
    comments = "Source: ping.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GrpcPingServiceGrpc {

  private GrpcPingServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.GrpcPingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.rose.msgservice.ping.PingRequest,
      com.rose.msgservice.ping.PingResponse> getPingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Ping",
      requestType = com.rose.msgservice.ping.PingRequest.class,
      responseType = com.rose.msgservice.ping.PingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rose.msgservice.ping.PingRequest,
      com.rose.msgservice.ping.PingResponse> getPingMethod() {
    io.grpc.MethodDescriptor<com.rose.msgservice.ping.PingRequest, com.rose.msgservice.ping.PingResponse> getPingMethod;
    if ((getPingMethod = GrpcPingServiceGrpc.getPingMethod) == null) {
      synchronized (GrpcPingServiceGrpc.class) {
        if ((getPingMethod = GrpcPingServiceGrpc.getPingMethod) == null) {
          GrpcPingServiceGrpc.getPingMethod = getPingMethod =
              io.grpc.MethodDescriptor.<com.rose.msgservice.ping.PingRequest, com.rose.msgservice.ping.PingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Ping"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rose.msgservice.ping.PingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rose.msgservice.ping.PingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcPingServiceMethodDescriptorSupplier("Ping"))
              .build();
        }
      }
    }
    return getPingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GrpcPingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcPingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcPingServiceStub>() {
        @java.lang.Override
        public GrpcPingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcPingServiceStub(channel, callOptions);
        }
      };
    return GrpcPingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrpcPingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcPingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcPingServiceBlockingStub>() {
        @java.lang.Override
        public GrpcPingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcPingServiceBlockingStub(channel, callOptions);
        }
      };
    return GrpcPingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GrpcPingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcPingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcPingServiceFutureStub>() {
        @java.lang.Override
        public GrpcPingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcPingServiceFutureStub(channel, callOptions);
        }
      };
    return GrpcPingServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GrpcPingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void ping(com.rose.msgservice.ping.PingRequest request,
        io.grpc.stub.StreamObserver<com.rose.msgservice.ping.PingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.rose.msgservice.ping.PingRequest,
                com.rose.msgservice.ping.PingResponse>(
                  this, METHODID_PING)))
          .build();
    }
  }

  /**
   */
  public static final class GrpcPingServiceStub extends io.grpc.stub.AbstractAsyncStub<GrpcPingServiceStub> {
    private GrpcPingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcPingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcPingServiceStub(channel, callOptions);
    }

    /**
     */
    public void ping(com.rose.msgservice.ping.PingRequest request,
        io.grpc.stub.StreamObserver<com.rose.msgservice.ping.PingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GrpcPingServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GrpcPingServiceBlockingStub> {
    private GrpcPingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcPingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcPingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.rose.msgservice.ping.PingResponse ping(com.rose.msgservice.ping.PingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPingMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GrpcPingServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GrpcPingServiceFutureStub> {
    private GrpcPingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcPingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcPingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rose.msgservice.ping.PingResponse> ping(
        com.rose.msgservice.ping.PingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GrpcPingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GrpcPingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PING:
          serviceImpl.ping((com.rose.msgservice.ping.PingRequest) request,
              (io.grpc.stub.StreamObserver<com.rose.msgservice.ping.PingResponse>) responseObserver);
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

  private static abstract class GrpcPingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GrpcPingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.rose.msgservice.ping.CorePingMsgApi.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GrpcPingService");
    }
  }

  private static final class GrpcPingServiceFileDescriptorSupplier
      extends GrpcPingServiceBaseDescriptorSupplier {
    GrpcPingServiceFileDescriptorSupplier() {}
  }

  private static final class GrpcPingServiceMethodDescriptorSupplier
      extends GrpcPingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GrpcPingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (GrpcPingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GrpcPingServiceFileDescriptorSupplier())
              .addMethod(getPingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
