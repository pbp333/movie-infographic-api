package com.moviefetcher.infrastructure;

import com.moviefetcher.application.Infographic;
import com.moviefetcher.application.Movie;
import com.moviefetcher.application.MovieFetcher;
import com.moviefetcher.infrastructure.moviefetcher.MovieFetcherClient;
import com.moviefetcher.infrastructure.moviefetcher.json.FetcherMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieFetcherImpl implements MovieFetcher {

    private final MovieFetcherClient client;

    @Autowired
    public MovieFetcherImpl(MovieFetcherClient tmdbClient) {
        this.client = tmdbClient;
    }

    @Override
    public List<Movie> fetchMoviesByInfographic(Long infographicId) {
        return client.fetchTrendingByWeek().stream().map(this::toMovie).collect(Collectors.toList());
    }

    @Override
    public List<Infographic> fetchInfographics() {
        return null;
    }

    private Movie toMovie(FetcherMovie fetcherMovie) {
        Movie.Builder builder = Movie.Builder.with();

        builder.id(fetcherMovie.getId());
        builder.posterPath(fetcherMovie.getPosterPath());
        builder.backDropPath(fetcherMovie.getBackDropPath());
        builder.overview(fetcherMovie.getOverview());
        builder.genres(fetcherMovie.getGenres());
        builder.originalTitle(fetcherMovie.getOriginalTitle());
        builder.name(fetcherMovie.getName());
        builder.title(fetcherMovie.getTitle());
        builder.originalName(fetcherMovie.getOriginalName());
        builder.voteCount(fetcherMovie.getVoteCount());
        builder.voteAverage(fetcherMovie.getVoteAverage());

        return builder.build();
    }
}
