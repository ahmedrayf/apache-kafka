package com.apache.kafka.producer;

import com.apache.kafka.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaJsonProducer implements Producer<Student> {

    @Value("${Apache-Kafka.topic.json}")
    private  String jsonTopic;
    
    private final KafkaTemplate<String, Student> kafkaTemplate;

    @Override
    public void send(Student student) {
        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, jsonTopic)
                .build();
        log.info("send message to Topic:: {}", message);
        kafkaTemplate.send(message);
    }

    @Override
    public Class<Student> getSupportedType() {
        return Student.class;
    }

}
