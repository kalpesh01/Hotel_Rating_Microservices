package com.hotelservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotels")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "location")
    private String location;

    @Column(name = "about")
    private String about;

}
