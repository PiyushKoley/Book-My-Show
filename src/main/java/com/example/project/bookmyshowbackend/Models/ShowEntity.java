package com.example.project.bookmyshowbackend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="shows")

public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="show_date", nullable = false)
    private LocalDate showDate;

    @Column(name="show_time", nullable = false)
    private LocalTime showTime;

    @CreationTimestamp
    @Column(name="created_at", nullable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TicketEntity> listOfTickets;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatsEntity> listOfShowSeatsEntity;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private MovieEntity movie;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private TheatreEntity theatre;
}
