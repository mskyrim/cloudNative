package com.rose.eventservice.service;

import com.rose.eventservice.dto.Event;

import java.util.List;

public interface EventService {
    void addEvent(final Event event);
    List<Event> getEventsByMsgId(String messageId);
    List<Event> getEvents();
}
