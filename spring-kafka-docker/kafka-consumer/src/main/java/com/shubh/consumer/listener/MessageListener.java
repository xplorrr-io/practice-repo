package com.shubh.consumer.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @KafkaListener(topics = "${app.kafka.topic}", groupId = "${app.kafka.group}")
    public void onMessage(ConsumerRecord<String, String> record) {
        System.out.printf("Consumed: topic=%s partition=%d offset=%d key=%s value=%s%n",
                record.topic(), record.partition(), record.offset(), record.key(), record.value());
    }
}
