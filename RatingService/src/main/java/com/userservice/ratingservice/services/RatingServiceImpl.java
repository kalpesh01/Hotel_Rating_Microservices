package com.userservice.ratingservice.services;

import com.userservice.ratingservice.entities.Rating;
import com.userservice.ratingservice.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getByUserId(String id) {
        return ratingRepository.findByUserId(id);
    }

    @Override
    public List<Rating> getByHotelId(String id) {
        return ratingRepository.findByHotelId(id);
    }
}
