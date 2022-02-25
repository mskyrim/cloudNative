package com.rose.msgservice.dao;

import com.rose.msgservice.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, String> {
}
