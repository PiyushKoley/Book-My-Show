package com.example.project.bookmyshowbackend.Models;

import com.example.project.bookmyshowbackend.enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name= "show_seats")
// this is for  each show (same seat is there for many shows)
public class ShowSeatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="rate", nullable = false)
    private int rate;

    @Column(name="seat_no", nullable = false)
    private String seatNo;

    @Column(name="seat_type", nullable = false)
    private SeatType seatType;


    @CreationTimestamp
    @Column(name="booked_at", nullable = false)
    private Date bookedAt;

    @Column(name="is_booked", columnDefinition = "bit(1) default 0", nullable = false)
    private boolean isBooked;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private TicketEntity ticket;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private ShowEntity show;
}
