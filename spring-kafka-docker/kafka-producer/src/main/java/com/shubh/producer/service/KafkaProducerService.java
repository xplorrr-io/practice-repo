package com.shubh.producer.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> template;
    private final String topic;

    public KafkaProducerService(
            KafkaTemplate<String, String> template,
            @Value("${app.kafka.topic}") String topic) {
        this.template = template;
        this.topic = topic;
    }

    public void send(String key, String value) {
        template.send(new ProducerRecord<>(topic, key, value));
    }
}
