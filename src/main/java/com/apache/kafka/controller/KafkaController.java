package com.apache.kafka.controller;


import com.apache.kafka.payload.Student;
import com.apache.kafka.producer.KafkaJsonProducer;
import com.apache.kafka.producer.KafkaStringProducer;
import com.apache.kafka.respone.BaseResponse;
import com.apache.kafka.service.KafkaService;
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

    private final KafkaService service;

    @PostMapping("/string")
    public ResponseEntity<BaseResponse<String>> sendMessage(@RequestBody String message) {
        service.sendMessage(message);
        return new ResponseEntity<>(BaseResponse.<String>builder()
                .httpStatus(HttpStatus.OK)
                .message("Message queued successfully")
                .timestamp(LocalDateTime.now()).build() , HttpStatus.OK);
    }

    @PostMapping("/json")
    public ResponseEntity<BaseResponse<String>> sendJson(@RequestBody Student student) {
        service.sendMessage(student);
        return new ResponseEntity<>(BaseResponse.<String>builder()
                .httpStatus(HttpStatus.OK)
                .message("Student queued successfully")
                .timestamp(LocalDateTime.now()).build() , HttpStatus.OK);
    }
}