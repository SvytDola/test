package com.example.demo.controller;

import com.example.demo.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaService kafkaService;

    @PostMapping("/message")
    public String sendMessage(@RequestParam String message, @RequestParam Integer partition) {
        kafkaService.sendMessage(message, partition);
        return message;
    }
}
