package com.hotelservice.services;

import com.hotelservice.entities.Hotel;
import com.hotelservice.exception.ResourceNotFoundException;
import com.hotelservice.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(Integer hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Resource Not Found Exception"));
    }
}
