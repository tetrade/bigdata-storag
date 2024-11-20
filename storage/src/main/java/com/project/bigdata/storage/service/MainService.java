package com.project.bigdata.storage.service;

import com.project.bigdata.storage.entities.RowMovie;
import com.project.bigdata.storage.repository.RowMovieReactiveRepository;
import com.project.bigdata.storage.repository.RowMovieRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;

@Service
@Log4j2
@RequiredArgsConstructor
public class MainService {

    private final RowMovieRepository movieRepository;
    private final RowMovieReactiveRepository reactiveRepository;

    @Transactional(readOnly = true)
    public Page<RowMovie> getPageableMovie(Integer pageNum, Integer pageSize) {
        return movieRepository.findAll(PageRequest.of(pageNum, pageSize));
    }

    public Flux<RowMovie> getAllFluxMovie() {
        return reactiveRepository.findAll().doOnError(e -> log.error(e.getMessage()));
    }
}
