package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
