package com.userservice.service;

import com.userservice.entities.Hotel;
import com.userservice.entities.Rating;
import com.userservice.entities.User;
import com.userservice.exception.ResourceNotFound;
import com.userservice.external.service.HotelService;
import com.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {

        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Given User by Id is not found"));
        String convertedNumb = Integer.toString(user.getId());
        System.out.println(convertedNumb);
        Rating[] userRatings = restTemplate.getForObject("http://RATINGSERVICE/ratings/get-rating-by-userid/" + Integer.toString(user.getId()), Rating[].class);
        List<Rating> userRatingList = Arrays.stream(userRatings).toList();

        List<Rating> collectedRatings = userRatingList.stream().map(rating -> {
//            Hotel[] hotel = restTemplate.getForObject("http://localhost:8082/get-hotel-by/" + rating.getRatingId(), Hotel[].class);

//            ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity("http://HOTELSERVICE/get-hotel-by/" + rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
//            Hotel hotel = hotelEntity.getBody();
            rating.setHotel(hotel);
            return rating;
        }).toList();
        user.setRatings(collectedRatings);
        return user;
    }
}
