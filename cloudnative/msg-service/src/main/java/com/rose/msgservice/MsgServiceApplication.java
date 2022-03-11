package com.rose.msgservice;

import com.rose.msgservice.dto.MessageDTO;
import com.rose.msgservice.restclient.EventClient;
import com.rose.msgservice.service.MessageService;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufJsonFormatHttpMessageConverter;

import java.util.UUID;

@SpringBootApplication
public class MsgServiceApplication {

    public static final String PUBSUB_NAME = "message-event-integration";
    public static final String TOPIC_NAME = "messageEvent";

    public static void main(String[] args) {
        SpringApplication.run(MsgServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(MessageService messageService) {
        return args -> {
            messageService.save(new MessageDTO(UUID.randomUUID().toString(), "Message body 1"));
            messageService.save(new MessageDTO(UUID.randomUUID().toString(), "Message body 2"));
            messageService.save(new MessageDTO(UUID.randomUUID().toString(), "Message body 3"));
        };
    }

    @Bean
    EventClient eventClientFeign(){
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(EventClient.class))
                .logLevel(Logger.Level.FULL)
                .target(EventClient.class, "http://localhost:4001/v1.0/publish/"+ PUBSUB_NAME +"/"+TOPIC_NAME);
    }

    @Bean
    public ProtobufJsonFormatHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufJsonFormatHttpMessageConverter();
    }

}
