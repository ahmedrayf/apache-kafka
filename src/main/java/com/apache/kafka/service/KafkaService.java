package com.apache.kafka.service;

import com.apache.kafka.producer.Producer;
import com.apache.kafka.producer.ProducerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaService {
    private final ProducerFactory producerFactory;

    public <T> void sendMessage(T message) {
        Producer<T> producer = (Producer<T>) producerFactory.getProducer(message.getClass());
        producer.send(message);
    }
}