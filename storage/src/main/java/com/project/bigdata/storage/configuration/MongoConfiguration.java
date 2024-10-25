package com.project.bigdata.storage.configuration;

import com.project.bigdata.storage.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class MongoConfiguration {

    @Autowired
    private MovieRepository mongoClient;


}
