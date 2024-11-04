package com.project.bigdata.storage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.amqp.core.MessageProperties.CONTENT_TYPE_JSON;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.bigdata.storage.entities.RowMovie;
import com.project.bigdata.storage.repository.RowMovieRepository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitMQTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RowMovieRepository rowMovieRepository;

    @Value("${rabbit.queue.name}")
    private String queueName;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final Path testFilePath =
            Path.of(Objects.requireNonNull(getClass().getClassLoader().getResource("movie.json")).toURI());

    RabbitMQTest() throws URISyntaxException {
    }

    @Test
    @Disabled("Исключительно для проверки работы слушателя очереди")
    void testRabbitSendAndSaving() throws IOException{
        byte[] testData = Files.readAllBytes(testFilePath);

        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType(CONTENT_TYPE_JSON);

        rabbitTemplate.send(queueName, new Message(testData, messageProperties));
    }
}
