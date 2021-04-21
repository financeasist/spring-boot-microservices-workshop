package com.rhrup.ratingsdataservice.service;

import com.rhrup.ratingsdataservice.dto.UserRating;
import org.springframework.stereotype.Service;

@Service
public interface RatingService {

     UserRating getUserRatings(String userId);

     void saveUserRatings(UserRating userRating);
}
