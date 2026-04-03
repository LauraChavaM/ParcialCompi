package com.example.enanospeleadores2.users.repository;

import com.example.enanospeleadores2.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByKeycloakId(String keycloakId);

    Optional<User> findByUsername(String username);
}
