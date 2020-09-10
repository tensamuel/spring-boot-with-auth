package com.test.user.userapp.repository;

import com.test.user.userapp.dto.User;
import com.test.user.userapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    public Optional<UserEntity> findByFirstName(String firstName);
}
