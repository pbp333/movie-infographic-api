package com.moviefetcher.application;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class Infographic {

    private final LocalDateTime creationDate;
    private final List<Movie> movies;

    private Infographic(LocalDateTime creationDate, List<Movie> movies) {
        this.creationDate = creationDate;
        this.movies = movies != null ? movies : Collections.emptyList();
    }
}
