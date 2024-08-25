package com.lyra.event.repository;

import com.lyra.event.entities.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long> {

    @Query("SELECT u FROM UserCredentials u JOIN FETCH u.roles WHERE u.email = :username")
    Optional<UserCredentials> findByEmailWithRoles(String username);

    @Query("SELECT u FROM UserCredentials u WHERE u.email = :email")
    Optional<UserCredentials> findByEmailCredentials(String email);

    @Query("SELECT uc FROM UserCredentials uc " +
            "JOIN FETCH uc.user u " +
            "WHERE uc.email = :username")
    Optional<UserCredentials> findWithUser(String username);


}
