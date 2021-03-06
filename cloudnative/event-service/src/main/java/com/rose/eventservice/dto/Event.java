package com.rose.eventservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Event {
    @Id
    private String id;
    private String actor;
    private String date;
    private String description;
    private String msgId;
}
