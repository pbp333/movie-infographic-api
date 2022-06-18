package com.moviefetcher.application.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "INFOGRAPHIC")
public class Infographic {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "infographic", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Movie> movies = new ArrayList<>();

    @Column(name = "CREATION_DATE", columnDefinition = "TIMESTAMP(6)")
    private LocalDateTime creationDate;

    private Infographic() {

    }

    private Infographic(List<Movie> movies, LocalDateTime creationDate) {
        this.movies = movies;
        this.creationDate = creationDate;
    }

    private Infographic(Long id, List<Movie> movies, LocalDateTime creationDate) {
        this.id = id;
        this.movies = movies;
        this.creationDate = creationDate;
    }

    public static Infographic from(Long id, List<Movie> movies, LocalDateTime creationDate) {
        return new Infographic(id, movies, creationDate);
    }

    public static Infographic fromNow(List<Movie> movies) {
        return new Infographic(movies, LocalDateTime.now());
    }

    public Long getId() {
        return id;
    }

    public List<Movie> getMovies() {
        return Collections.unmodifiableList(movies);
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
