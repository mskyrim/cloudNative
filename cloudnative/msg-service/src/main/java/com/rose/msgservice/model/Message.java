package com.rose.msgservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Message {
    @Id
    private String id;
    private String systemId;
    private String body;
}
