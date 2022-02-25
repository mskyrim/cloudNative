package com.rose.msgservice.web;

import com.rose.msgservice.dto.Version;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(path = "version")
public class VersionController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Version version() {
        Version version = new Version();
        version.setVersion("v-0.1");
        version.setReleaseDate(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return version;
    }
}
