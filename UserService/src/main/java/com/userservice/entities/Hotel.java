package com.userservice.entities;

import lombok.Data;

@Data
public class  Hotel {
    private Integer id;

    private String hotelName;

    private String location;

    private String about;
}
