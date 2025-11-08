package com.shubh.producer.controller;

import com.shubh.producer.payload.MessagePayload;
import com.shubh.producer.service.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final KafkaProducerService service;

    public MessageController(KafkaProducerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> publish(@RequestBody MessagePayload payload) {
        service.send(payload.key(), payload.value());
        return ResponseEntity.ok("sent");
    }
}
