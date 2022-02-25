package com.rose.eventservice.service;

import com.rose.eventservice.dao.MessageEventRepository;
import com.rose.eventservice.dto.Event;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    private final MessageEventRepository messageEventRepository;

    public EventServiceImpl(MessageEventRepository messageEventRepository) {
        this.messageEventRepository = messageEventRepository;
    }

    @Override
    public void addEvent(Event event) {
        messageEventRepository.save(event);
    }

    @Override
    public List<Event> getEventsByMsgId(String messageId) {
        return null;
    }

    @Override
    public List<Event> getEvents() {
        return messageEventRepository.findAll();
    }
}
