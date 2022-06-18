package com.moviefetcher.api;

import com.moviefetcher.application.api.MovieInfographicsService;
import com.moviefetcher.application.domain.Infographic;
import com.moviefetcher.application.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/infographics")
public class MovieInfographicController extends ErrorController {

    private final MovieInfographicsService service;

    @Autowired
    public MovieInfographicController(MovieInfographicsService service) {
        this.service = service;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Infographic> getInfographics() {
        return service.listInfographics();
    }

    @GetMapping("/{infographicId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> getTrendingByWeek(@PathParam("infographicId") Long infographicId, @RequestParam("page") int page, @RequestParam("size") int size) {

        validatePageAndSize(page, size);

        return service.listByInfographicId(infographicId, page, size);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create() {
        service.createInfographic();
    }

    private void validatePageAndSize(int page, int size) {
        if (page > 5 || page < 1) {
            throw new IllegalArgumentException("Page is invalid");
        }

        if (size > 100 || size < 1) {
            throw new IllegalArgumentException("Size is invalid");
        }
    }

}
