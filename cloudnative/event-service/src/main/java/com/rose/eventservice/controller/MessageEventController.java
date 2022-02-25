package com.rose.eventservice.controller;

import com.rose.eventservice.dto.Event;
import com.rose.eventservice.service.EventService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "event")
public class MessageEventController {
    private final EventService eventService;

    public MessageEventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Event> findAll(){
        return this.eventService.getEvents();
    }
}
