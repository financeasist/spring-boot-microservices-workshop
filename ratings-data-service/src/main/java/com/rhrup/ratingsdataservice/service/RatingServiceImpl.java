package com.rhrup.ratingsdataservice.service;

import com.rhrup.ratingsdataservice.dto.UserRating;
import com.rhrup.ratingsdataservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public UserRating getUserRatings(String userId) {
        return new UserRating(ratingRepository.findAllByUserId(userId));
    }

    @Override
    public void saveUserRatings(UserRating userRating) {
        ratingRepository.saveAll(userRating.getRatings());
    }
}
