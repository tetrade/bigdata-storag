package com.project.bigdata.storage;

import static org.assertj.core.api.Assertions.assertThat;

import com.project.bigdata.storage.entities.RowMovie;
import com.project.bigdata.storage.repository.ProcessMovieRepository;
import com.project.bigdata.storage.repository.RowMovieRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@DataMongoTest
class RepositoryTest {

    @Autowired
    public RowMovieRepository rowMovieRepository;

    @Autowired
    public ProcessMovieRepository processMovieRepository;

    @Test
    void readsFirstPageCorrectly() {
        Page<RowMovie> persons = rowMovieRepository.findAll(PageRequest.of(0, 10));
        assertThat(persons).isNotNull();
    }
}
