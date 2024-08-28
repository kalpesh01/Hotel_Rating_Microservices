package com.userservice.ratingservice.controller;

import com.userservice.ratingservice.entities.Rating;
import com.userservice.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/add-rating")
    public ResponseEntity<?> addRating(@RequestBody Rating rating){
        Rating rating1 = ratingService.addRating(rating);
        if(rating1 != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }

    }

    @GetMapping("/get-rating-by-userid/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable String userId){
        List<Rating> ratings = ratingService.getByUserId(userId);
        if(ratings != null){
            return ResponseEntity.status(HttpStatus.FOUND).body(ratings);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @GetMapping("/get-rating-by-hotelid/{hotelId}")
    public ResponseEntity<?> getByHotelId(@PathVariable String hotelId){
        List<Rating> ratings = ratingService.getByHotelId(hotelId);
        if(ratings != null){
            return ResponseEntity.status(HttpStatus.FOUND).body(ratings);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
