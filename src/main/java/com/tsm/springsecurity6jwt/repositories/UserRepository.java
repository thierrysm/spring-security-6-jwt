package com.tsm.springsecurity6jwt.repositories;

import com.tsm.springsecurity6jwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
