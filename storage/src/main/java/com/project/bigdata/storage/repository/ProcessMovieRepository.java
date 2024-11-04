package com.project.bigdata.storage.repository;

import com.project.bigdata.storage.entities.ProcessMovie;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessMovieRepository extends MongoRepository<ProcessMovie, String> {
}
