package com.lyra.event.repository;

import com.lyra.event.entities.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long> {

    @Query("SELECT u FROM UserCredentials u JOIN FETCH u.roles WHERE u.email = :username")
    Optional<UserCredentials> findByEmailWithRoles(String username);
}
