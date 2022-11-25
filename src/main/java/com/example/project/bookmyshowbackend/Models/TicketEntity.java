package com.example.project.bookmyshowbackend.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="tickets")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String allottedSeats;

    @Column(name="amount", nullable = false)
    private int amount;

    @CreationTimestamp
    @Column(name="booked_at", nullable = false)
    private Date createdOn;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private UserEntity user;   // this is the foreign key that will connect with the user table;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private ShowEntity show;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatsEntity> listOfBookedSeats;


}
