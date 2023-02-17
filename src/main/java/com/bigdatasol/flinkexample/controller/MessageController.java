package com.bigdatasol.flinkexample.controller;

import com.bigdatasol.flinkexample.serivice.KafkaSender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaSender kafkaSender;

    @GetMapping
    public ResponseEntity<HttpStatus> initFlinkChain() {

        kafkaSender.send("OLOLOLOLO");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
