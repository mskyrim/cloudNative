package com.rose.msgservice.restclient;

import com.rose.msgservice.dto.MsgEvent;
import feign.Headers;
import feign.RequestLine;

public interface EventClient {
    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void create(MsgEvent messageEvent);
}
