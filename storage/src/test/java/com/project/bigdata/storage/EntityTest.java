package com.project.bigdata.storage;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.bigdata.storage.entities.RowMovie;

import org.junit.jupiter.api.Test;

class EntityTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final Path testFilePath = Path.of(Objects.requireNonNull(getClass().getClassLoader().getResource("movie.json")).toURI());

    EntityTest() throws URISyntaxException {
    }

    @Test
    void testRowMovieEntity() throws IOException {
        RowMovie rowMovie = MAPPER.readValue(testFilePath.toFile(), RowMovie.class);
        assertThat(rowMovie).usingRecursiveAssertion().hasNoNullFields();
    }
}
