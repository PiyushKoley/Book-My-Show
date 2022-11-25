package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Models.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowEntity, Integer> {
}
