package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

    boolean existsByName(String name);

}
