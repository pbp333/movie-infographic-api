package com.moviefetcher.application;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movie {

    private final String posterPath;
    private final boolean adult;
    private final String overview;
    private final LocalDate releaseDate;
    private final List<String> genres = new ArrayList<>();
    private final String originalTitle;
    private final String originalLanguage;
    private final String title;
    private final BigDecimal popularity;
    private final int voteCount;
    private final BigDecimal voteAverage;

    private Movie(Builder builder) {
        this.posterPath = builder.posterPath;
        this.adult = builder.adult;
        this.overview = builder.overview;
        this.releaseDate = builder.releaseDate;
        this.genres.addAll(builder.genres);
        this.originalTitle = builder.originalTitle;
        this.originalLanguage = builder.originalLanguage;
        this.title = builder.title;
        this.popularity = builder.popularity;
        this.voteCount = builder.voteCount;
        this.voteAverage = builder.voteAverage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPopularity() {
        return popularity;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public BigDecimal getVoteAverage() {
        return voteAverage;
    }


    public static final class Builder {
        private String posterPath;
        private boolean adult;
        private String overview;
        private LocalDate releaseDate;
        private List<String> genres = new ArrayList<>();
        private String originalTitle;
        private String originalLanguage;
        private String title;
        private BigDecimal popularity;
        private int voteCount;
        private BigDecimal voteAverage;

        private Builder() {
        }

        public static Builder with() {
            return new Builder();
        }

        public Builder posterPath(String posterPath) {
            this.posterPath = posterPath;
            return this;
        }

        public Builder adult(boolean adult) {
            this.adult = adult;
            return this;
        }

        public Builder overview(String overview) {
            this.overview = overview;
            return this;
        }

        public Builder releaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder genres(List<String> genres) {
            this.genres = genres;
            return this;
        }

        public Builder originalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
            return this;
        }

        public Builder originalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder popularity(BigDecimal popularity) {
            this.popularity = popularity;
            return this;
        }

        public Builder voteCount(int voteCount) {
            this.voteCount = voteCount;
            return this;
        }

        public Builder voteAverage(BigDecimal voteAverage) {
            this.voteAverage = voteAverage;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
