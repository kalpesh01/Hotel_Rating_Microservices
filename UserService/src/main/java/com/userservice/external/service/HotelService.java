package com.userservice.external.service;

import com.userservice.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient("HOTELSERVICE")
public interface HotelService {

    @GetMapping("/hotels/get-hotel-by/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);
}
