package com.rose.eventservice.dao;

import com.rose.eventservice.dto.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageEventRepository extends JpaRepository<Event, String> {
}
