package org.example.monitoringservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.monitoringservice.model.User;
import org.example.monitoringservice.service.UserService;
import org.example.monitoringservice.util.request.UserRequest;
import org.example.monitoringservice.util.validation.interfaces.ValidAccessToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{accessToken}")
    public ResponseEntity<User> getUserByAccessToken(@PathVariable(name = "accessToken") @ValidAccessToken String accessToken){
        return ResponseEntity.ok(userService.findUserByAccessToken(accessToken));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.createUser(userRequest));
    }
}
