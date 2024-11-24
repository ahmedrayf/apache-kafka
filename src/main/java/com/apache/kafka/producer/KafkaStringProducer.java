package com.apache.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaStringProducer implements Producer<String> {

    @Value("${Apache-Kafka.topic.string}")
    private  String stringTopic;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String message) {
        log.info("send message to Topic:: {}", message);
        kafkaTemplate.send(stringTopic, message);
    }

    @Override
    public Class<String> getSupportedType() {
        return String.class;
    }
}
