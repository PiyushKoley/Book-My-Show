package com.example.project.bookmyshowbackend.Models;

import com.example.project.bookmyshowbackend.enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="theatre_seats")
public class TheatreSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="seatNo", nullable = false)
    private String seatNo;

    @Column(name="seat_type",nullable = false)
    private SeatType seatType;

    @Column(name="rate", nullable = false)
    private int rate;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private TheatreEntity theatre;


}
