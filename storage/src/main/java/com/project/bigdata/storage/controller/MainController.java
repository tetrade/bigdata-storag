package com.project.bigdata.storage.controller;

import com.project.bigdata.storage.entities.ProcessMovie;
import com.project.bigdata.storage.repository.RowMovieReactiveRepository;
import com.project.bigdata.storage.service.MainService;

import org.springframework.data.web.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(allowCredentials = "true", originPatterns = "*")
@AllArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/page-data")
    public ResponseEntity<PagedModel<ProcessMovie>> getProcessMovies(
            @RequestParam(defaultValue = "0", required = false) Integer pageNum,
            @RequestParam(defaultValue = "50", required = false) Integer pageSize
    ) {
        return ResponseEntity.ok(
                new PagedModel<>(mainService.getPageableMovie(pageNum, pageSize).map(ProcessMovie.class::cast))
        );
    }

    @GetMapping(path = "/stream-data", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<ProcessMovie> getProcessMoviesAsStream() {
        return mainService.getAllFluxMovie().map(ProcessMovie.class::cast);
    }

}
