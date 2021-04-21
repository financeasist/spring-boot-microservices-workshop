package com.rhrup.ratingsdataservice.repository;

import com.rhrup.ratingsdataservice.model.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends CrudRepository<Rating, String> {

    List<Rating> findAllByUserId(String userId);
}
