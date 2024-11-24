package com.apache.kafka.consumer;

import com.apache.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {


    @KafkaListener(topics = "${Apache-Kafka.topic.string}" , groupId = "myGroup")
    public void stringListener(String message) {
        log.info("Consume message from \"${Apache-Kafka.topic.string}\":: {}",message);
    }


    @KafkaListener(topics = "${Apache-Kafka.topic.json}" , groupId = "myGroup")
    public void jsonListener(Student student) {
        log.info("Consume message from \"${Apache-Kafka.topic.json}\":: {}",student.toString());
    }
}
