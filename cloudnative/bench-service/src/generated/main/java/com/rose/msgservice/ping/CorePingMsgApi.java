// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ping.proto

package com.rose.msgservice.ping;

public final class CorePingMsgApi {
  private CorePingMsgApi() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_PingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_PingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_PingResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_PingResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nping.proto\022\004grpc\"\036\n\013PingRequest\022\017\n\007mes" +
      "sage\030\001 \001(\t\"\037\n\014PingResponse\022\017\n\007message\030\001 " +
      "\001(\t2@\n\017GrpcPingService\022-\n\004Ping\022\021.grpc.Pi" +
      "ngRequest\032\022.grpc.PingResponseB,\n\030com.ros" +
      "e.msgservice.pingB\016CorePingMsgApiP\001b\006pro" +
      "to3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_grpc_PingRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_grpc_PingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_PingRequest_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_grpc_PingResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_grpc_PingResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_PingResponse_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
