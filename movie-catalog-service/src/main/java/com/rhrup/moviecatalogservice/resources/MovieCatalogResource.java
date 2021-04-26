package com.rhrup.moviecatalogservice.resources;

import com.rhrup.moviecatalogservice.models.CatalogItem;
import com.rhrup.moviecatalogservice.services.MoviInfoService;
import com.rhrup.moviecatalogservice.services.UserRatingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/catalogs")
public class MovieCatalogResource {

    @Autowired
    private MoviInfoService moviInfoService;

    @Autowired
    private UserRatingInfoService userRatingInfoService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        return userRatingInfoService.getUserRating(userId)
                .getRatings()
                .stream()
                .map(rating -> moviInfoService.getCatalogItem(rating))
                .collect(toList());
    }
}









/*
    Alternative WebClient way
        Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/"+ rating.getMovieId())
        .retrieve().bodyToMono(Movie.class).block();
*/