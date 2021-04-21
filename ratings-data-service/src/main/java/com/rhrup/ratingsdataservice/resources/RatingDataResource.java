package com.rhrup.ratingsdataservice.resources;

import com.rhrup.ratingsdataservice.dto.UserRating;
import com.rhrup.ratingsdataservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResource {

    @Autowired
    private RatingService ratingService;


    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        return ratingService.getUserRatings(userId);
    }
}
