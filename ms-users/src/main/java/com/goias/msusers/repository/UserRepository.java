package com.goias.msusers.repository;

import com.goias.msusers.model.User;
import com.goias.msusers.resources.dto.response.UserResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String name);

    Optional<User> findByUserEmail(String email);
}
