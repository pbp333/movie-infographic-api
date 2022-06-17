package com.moviefetcher.application;

import java.util.List;

public interface MovieFetcher {

    List<Movie> fetchMoviesByInfographic(Long infographicId);

    List<Infographic> fetchInfographics();
}
