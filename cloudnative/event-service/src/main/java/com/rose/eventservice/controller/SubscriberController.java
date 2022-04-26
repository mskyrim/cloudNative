package com.rose.eventservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rose.eventservice.dto.Event;
import com.rose.eventservice.service.EventService;
import io.dapr.client.domain.CloudEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SubscriberController {
    private final EventService eventService;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static Logger logger = LoggerFactory.getLogger(SubscriberController.class);

    public SubscriberController(EventService eventService) {
        this.eventService = eventService;
    }

    //@Topic(name = "messageEvent", pubsubName = "kafka-message-event-integration")
    @PostMapping(path = "/message-operations")
    public void consumeMessageEvents(@RequestBody(required = false) CloudEvent event){
        try {
            var messageEvent = OBJECT_MAPPER.convertValue(event.getData(), Event.class);
            logger.info("Received Event : " + OBJECT_MAPPER.writeValueAsString(messageEvent));
            messageEvent.setId(UUID.randomUUID().toString());
            eventService.addEvent(messageEvent);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
