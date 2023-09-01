package com.example.demo.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
class KafkaTopicConfig {

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("reflectoring-1")
                .partitions(3)
                .replicas(3)
                .build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("reflectoring-2")
                .build();
    }
}
