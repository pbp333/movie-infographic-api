package com.moviefetcher.api.json;

import java.time.LocalDateTime;

public class InfographicJson {

    private final Long id;
    private final LocalDateTime creationDate;

    private InfographicJson(Long id, LocalDateTime creationDate) {
        this.creationDate = creationDate;
        this.id = id;
    }
}
