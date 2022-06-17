package com.moviefetcher.infrastructure.tmdb;

import com.moviefetcher.infrastructure.tmdb.json.FetcherMovie;

import java.util.List;

public interface MovieFetcherClient {

    List<FetcherMovie> fetchTrendingByWeek();

}
