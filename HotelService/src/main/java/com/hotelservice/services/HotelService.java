package com.hotelservice.services;

import com.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {
    public Hotel addHotel(Hotel hotel);
    public List<Hotel> getAllHotels();
    public Hotel getHotelById(Integer hotelId);
}
