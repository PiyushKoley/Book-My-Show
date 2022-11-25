package com.example.project.bookmyshowbackend.Models;

import com.example.project.bookmyshowbackend.enums.SeatType;
import com.example.project.bookmyshowbackend.enums.TheatreType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="theatres")
public class TheatreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="type", nullable = false)
    private TheatreType type;             /// it is a enum type

    @Column(name="city", nullable = false)
    private String city;

    @Column(name="address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TheatreSeatEntity> listOfSeat;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> listOfShows;
}
