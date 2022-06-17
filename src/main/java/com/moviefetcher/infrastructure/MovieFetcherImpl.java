package com.moviefetcher.infrastructure;

import com.moviefetcher.application.Movie;
import com.moviefetcher.application.MovieFetcher;
import com.moviefetcher.infrastructure.moviefetcher.MovieFetcherClient;
import com.moviefetcher.infrastructure.moviefetcher.json.FetcherMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
    public List<Movie> fetchMoviesByWeek() {
        return client.fetchTrendingByWeek().stream().map(this::toMovie).collect(Collectors.toList());
    }

    private Movie toMovie(FetcherMovie fetcherMovie) {
        Movie.Builder builder = Movie.Builder.with();

        builder.posterPath(fetcherMovie.getPosterPath());
        builder.adult(fetcherMovie.isAdult());
        builder.overview(fetcherMovie.getOverview());
        builder.releaseDate(LocalDate.parse(fetcherMovie.getReleaseDate()));
        builder.genres(fetcherMovie.getGenres());
        builder.originalTitle(fetcherMovie.getOriginalTitle());
        builder.originalLanguage(fetcherMovie.getOriginalLanguage());
        builder.title(fetcherMovie.getTitle());
        builder.popularity(fetcherMovie.getPopularity());
        builder.voteCount(fetcherMovie.getVoteCount());
        builder.voteAverage(fetcherMovie.getVoteAverage());

        return builder.build();
    }
}
