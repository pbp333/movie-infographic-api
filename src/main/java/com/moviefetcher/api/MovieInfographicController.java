package com.moviefetcher.api;

import com.moviefetcher.application.Infographic;
import com.moviefetcher.application.Movie;
import com.moviefetcher.application.MovieFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/infographic")
public class MovieInfographicController {

    private final MovieFetcher fetcher;

    @Autowired
    public MovieInfographicController(MovieFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @GetMapping()
    public List<Infographic> getInfographics() {
        return fetcher.fetchInfographics();
    }

        @GetMapping("/{infographicId}")
    public List<Movie> getTrendingByWeek(Long infographicId) {
        return fetcher.fetchMoviesByInfographic(infographicId);
    }
}
