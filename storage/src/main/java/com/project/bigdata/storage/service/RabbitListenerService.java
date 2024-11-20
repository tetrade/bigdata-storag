package com.project.bigdata.storage.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.bigdata.storage.entities.RowMovie;
import com.project.bigdata.storage.repository.RowMovieRepository;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class RabbitListenerService {

    private final RowMovieRepository rowMovieRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "${rabbit.queue.name}")
    @Transactional
    public void processMessage(String content) {
        log.debug("Received new message to save");
        if (content == null || content.isEmpty()) {
            log.warn("Received null or empty message");
            return;
        }
        try {
            RowMovie rowMovie = objectMapper.readValue(content, RowMovie.class);
            log.info("Movie to save: {}. Now have: {} movies.", rowMovie, rowMovieRepository.count());
            rowMovieRepository.save(rowMovie);
        } catch (Exception e) {
           log.error(e);
        }
    }
}
