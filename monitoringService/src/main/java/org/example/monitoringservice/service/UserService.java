package org.example.monitoringservice.service;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.monitoringservice.model.User;
import org.example.monitoringservice.repository.UserDao;
import org.example.monitoringservice.util.request.UserRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private UserDao userDao;

    public User createUser(UserRequest request) {
        if (!userDao.existsByUsernameAndEmail(request.username(), request.email())) {
            User user = User.builder()
                    .email(request.email())
                    .username(request.username())
                    .build();
            if (request.accessToken() == null || request.accessToken().isEmpty()) {
                user.setAccessToken(UUID.randomUUID().toString());
            }
            return userDao.save(user);
        } else {
            String msg = String.format("Requested user with email: %s and username: %s exists.",
                    request.email(),
                    request.username());
            log.error(msg);
            throw new EntityExistsException(msg);
        }
    }

    public User findUserByAccessToken(String accessToken) {
        if (accessToken == null || accessToken.isEmpty()) {
            String msg = "User couldn't be found with null or empty user accessToken.";
            log.error(msg);
            throw new IllegalArgumentException(msg);
        }

        Optional<User> optionalUser = userDao.findByAccessToken(accessToken);
        if (optionalUser.isEmpty()) {
            String msg = String.format("User with passed accessToken: %s couldn't be found. " +
                            "Rolling back monitoring endpoint deletion.",
                    accessToken);
            log.error(msg);
            throw new IllegalArgumentException(msg);
        }

        return optionalUser.get();
    }
}
