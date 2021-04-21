package com.rhrup.ratingsdataservice.dto;

import com.rhrup.ratingsdataservice.model.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRating {
    private List<Rating> ratings;
}
