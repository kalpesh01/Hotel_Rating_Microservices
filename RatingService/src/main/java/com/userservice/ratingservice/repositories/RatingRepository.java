package com.userservice.ratingservice.repositories;

import com.userservice.ratingservice.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating,Integer> {

    List<Rating> findByUserId(String id);

    List<Rating> findByHotelId(String id);
}
