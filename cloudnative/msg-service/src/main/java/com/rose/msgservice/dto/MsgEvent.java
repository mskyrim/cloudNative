package com.rose.msgservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MsgEvent {
    private String actor;
    private String date;
    private String description;
    private String msgId;
}
