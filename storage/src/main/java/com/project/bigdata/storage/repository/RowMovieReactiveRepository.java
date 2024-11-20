package com.project.bigdata.storage.repository;

import com.project.bigdata.storage.entities.RowMovie;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface RowMovieReactiveRepository extends ReactiveMongoRepository<RowMovie, String> {

    Flux<RowMovie> findAllBy();

}
