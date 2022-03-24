package com.rose.msgservice.web;

import com.rose.msgservice.dto.Ping;
import com.rose.msgservice.dto.Pong;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ping")
public class PingController {


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Pong pingRequest(@RequestBody Ping ping){
        var pong = new Pong();
        pong.setPong("your Http ping message " + ping.getPing() + " is received correctly");
        return pong;
    }
}
