package org.example.monitoringservice.repository;

import org.example.monitoringservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findByAccessToken(String accessToken);
    boolean existsByAccessToken(String accessToken);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsernameAndEmail(String username, String email);

}
