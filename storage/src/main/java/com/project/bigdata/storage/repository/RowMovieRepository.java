package com.project.bigdata.storage.repository;

import com.project.bigdata.storage.entities.RowMovie;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowMovieRepository extends MongoRepository<RowMovie, String> {
}
