package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Models.ShowSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ShowSeatsRepository extends JpaRepository<ShowSeatsEntity, Integer> {
}
