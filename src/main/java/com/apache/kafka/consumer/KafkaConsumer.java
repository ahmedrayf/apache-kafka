package com.apache.kafka.consumer;

import com.apache.kafka.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "topic1" , groupId = "myGroup")
//    public void messageListener(String message) {
//        log.info("Consume message from topic:: {}",message);
//    }


    @KafkaListener(topics = "topic1" , groupId = "myGroup")
    public void jsonListener(Student student) {
        log.info("Consume message from topic:: {}",student.toString());
    }
}
