package com.apache.kafka.producer;

public interface Producer<T> {
     void send(T object);
     Class<T> getSupportedType();
}
