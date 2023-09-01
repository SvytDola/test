package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Log4j2
@Service
@RequiredArgsConstructor
public class KafkaService {

    private final NewTopic topic1;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message, Integer partition) {
        try {
            kafkaTemplate.send(topic1.name(), partition, message, message).get();
            log.info("Send message to kafka");
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @KafkaListener(
            groupId = "reflectoring-user",
            topics = "reflectoring-1")
    void listenToPartitionWithOffset(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.OFFSET) int offset) {
        log.info("Received message [{}] from partition-{} with offset-{}",
                message,
                partition,
                offset);
    }
}
