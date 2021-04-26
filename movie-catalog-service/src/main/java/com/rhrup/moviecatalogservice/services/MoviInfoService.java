package com.rhrup.moviecatalogservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rhrup.moviecatalogservice.models.CatalogItem;
import com.rhrup.moviecatalogservice.models.Movie;
import com.rhrup.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class MoviInfoService {

    private MovieInfoFeignClient movieInfoFeignClient;

    public MoviInfoService(MovieInfoFeignClient movieInfoFeignClient) {
        this.movieInfoFeignClient = movieInfoFeignClient;
    }

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    public CatalogItem getCatalogItem(Rating rating) {
        Movie movie = movieInfoFeignClient.getMovieInfo(rating.getMovieId());
        return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRatingValue());
    }

    private CatalogItem getFallbackCatalogItem(Rating rating) {
        return new CatalogItem("Movie name not found", "", rating.getRatingValue());
    }

    @FeignClient(value = "movie-info-service")
    static interface MovieInfoFeignClient {
        @GetMapping("/movies/{movieId}")
        public Movie getMovieInfo(@PathVariable("movieId") String movieId);
    }
}
