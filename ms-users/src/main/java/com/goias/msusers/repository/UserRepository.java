package com.goias.msusers.repository;

import com.goias.msusers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String name);

    Optional<User> findByUserEmail(String email);


    @Query("SELECT u FROM User u WHERE u.userEmail = :email AND u.recoverCode = :code")
    Optional<User> findByUserEmailAndRecoverCode(@Param("email") String email, @Param("code") String code);
}
