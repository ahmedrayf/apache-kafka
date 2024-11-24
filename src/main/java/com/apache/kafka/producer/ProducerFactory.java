package com.apache.kafka.producer;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class ProducerFactory {

    private final Map<Class<?>, Producer<?>> producerMap = new HashMap<>();
    private final Map<String, Producer<?>> producerBeans;

    public ProducerFactory(Map<String, Producer<?>> producerBeans) {
        this.producerBeans = producerBeans;
    }

    @PostConstruct
    private void init() {
        for (Producer<?> producer : producerBeans.values()) {
            producerMap.put(producer.getSupportedType(), producer);
        }
        log.info("Registered Producers: {}", producerMap.keySet());
    }

    @SuppressWarnings("unchecked")
    public <T> Producer<T> getProducer(Class<T> messageType) {
        Producer<?> producer = producerMap.get(messageType);
        if (producer == null) {
            throw new IllegalArgumentException("No producer found for type: " + messageType.getName());
        }
        return (Producer<T>) producer;
    }
}
