# Spring Boot Kafka Demo

This project demonstrates a Spring Boot application integrating Apache Kafka for message streaming and processing. It uses the Strategy Pattern to dynamically select Kafka producers based on the message type.

## Kafka Intro session:
[Session](https://docs.google.com/presentation/d/1gu6QNSRF0heW_n7aZXaR5HohxW6sQPJlZgKuBX272Jc/edit?usp=sharing)


## Features
- Kafka Producer: Sends messages to a Kafka topic.
- Kafka Consumer: Listens to messages from a Kafka topic.
- Easy configuration through `application.properties`.
- Dynamic producer selection using the Strategy Pattern.
- Configuration-based Kafka topic creation.

---

## Prerequisites
Before running this application, ensure you have the following installed:
- Spring Boot 3.0+
- **Java 17** or later
- **Apache Kafka** and **Zookeeper** (running locally or on a server)
- **Maven**

---

## Setup and Run
### Step 1: Clone the Repository
```bash
git clone https://github.com/ahmedrayf/apache-kafka.git
cd spring-boot-kafka-demo
```
### Step 2: Start Kafka and Zookeeper using docker
```bash
docker compose up -d 
```

### Step 3: Build and Run the Maven Application
```bash
mvn spring-boot:run
```
## REST APIs
### Send String Message
```bash
POST /api/v1/message/string
```
#### Request Body:
```bash
"Hello, Kafka!"
```

### Send Json Message
``` bash
POST /api/v1/message/json
```
#### Request Body:
```bash
{
    "id": 1,
    "firstName": "Ahmed",
    "lastName": "Rayef"
}

```

## License
This project is licensed under Ahmed Rayef License.

## Author
### Ahmed Rayef

[Website](https://ahmedrayf.github.io/)

[LinkedIn](https://www.linkedin.com/in/ahmedrayf/)

[Email](ahmedrayf@hotmail.com)


