# Spring Boot Kafka Demo

This project demonstrates how to integrate **Apache Kafka** with a **Spring Boot** application. It showcases both producer and consumer functionalities for sending and receiving messages using Kafka.

## Features
- Kafka Producer: Sends messages to a Kafka topic.
- Kafka Consumer: Listens to messages from a Kafka topic.
- Easy configuration through `application.properties`.

---

## Prerequisites
Before running this application, ensure you have the following installed:
- **Java 17** or later
- **Apache Kafka** and **Zookeeper** (running locally or on a server)
- **Maven** or **Gradle**

---

## Setup and Run
### Step 1: Clone the Repository
```bash
git clone https://github.com/ahmedrayf/apache-kafka.git
cd spring-boot-kafka-demo
```
### Step 2: Start Kafka and Zookeeper
```bash
zookeeper-server-start.sh config/zookeeper.properties
kafka-server-start.sh config/server.properties
```

### Step 3: Build and Run the Maven Application
```bash
mvn spring-boot:run
```

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Author
### Ahmed Rayf
[LinkedIn](https://www.linkedin.com/in/ahmedrayf/)

[Email](ahmedrayf@hotmail.com)


