package com.apache.kafka.controller;


import com.apache.kafka.payload.Student;
import com.apache.kafka.producer.KafkaJsonProducer;
import com.apache.kafka.producer.KafkaProducer;
import com.apache.kafka.respone.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/message")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping("/send")
    public ResponseEntity<BaseResponse<String>> sendMessage(@RequestBody String message) {
        kafkaProducer.send(message);
        return new ResponseEntity<>(BaseResponse.<String>builder()
                .httpStatus(HttpStatus.OK)
                .message("Message queued successfully")
                .timestamp(LocalDateTime.now()).build() , HttpStatus.OK);
    }

    @PostMapping("/json")
    public ResponseEntity<BaseResponse<String>> sendJson(@RequestBody Student student) {
        kafkaJsonProducer.send(student);
        return new ResponseEntity<>(BaseResponse.<String>builder()
                .httpStatus(HttpStatus.OK)
                .message("Student queued successfully")
                .timestamp(LocalDateTime.now()).build() , HttpStatus.OK);
    }
}