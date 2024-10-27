package org.example.monitoringservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/health-check")
public class HealthController {
    @GetMapping
    public ResponseEntity<?> healthCheck(){
        return new ResponseEntity<>("Health Check", HttpStatus.OK);
    }
}
