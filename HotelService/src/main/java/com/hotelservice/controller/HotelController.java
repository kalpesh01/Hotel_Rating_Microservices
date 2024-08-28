package com.hotelservice.controller;

import com.hotelservice.entities.Hotel;
import com.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/add-hotel")
    public ResponseEntity<?> addHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.addHotel(hotel);
        if(hotel1 != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @GetMapping("/get-all-hotels")
    public ResponseEntity<?> getAllHotels(){
        List<Hotel> hotels = hotelService.getAllHotels();
        if(hotels != null){
            return ResponseEntity.status(HttpStatus.OK).body(hotels);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/get-hotel-by/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable Integer id){
        Hotel hotel = hotelService.getHotelById(id);
        if(hotel != null){
            return ResponseEntity.status(HttpStatus.OK).body(hotel);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
