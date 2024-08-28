package com.userservice.ratingservice.services;

import com.userservice.ratingservice.entities.Rating;

import java.util.List;

public interface RatingService {
    public Rating addRating(Rating rating);

    public List<Rating> getAllRating();

    public List<Rating> getByUserId(String id);
    public List<Rating> getByHotelId(String id);

}
