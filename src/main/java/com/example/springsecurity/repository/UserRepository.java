package com.example.springsecurity.repository;

import com.example.springsecurity.model.entity.UserEntity;
import com.example.springsecurity.model.response.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByUsername(String username);
}
