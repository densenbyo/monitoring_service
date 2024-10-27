package org.example.monitoringservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.monitoringservice.model.MonitoringEndpoint;
import org.example.monitoringservice.service.MonitoringEndpointService;
import org.example.monitoringservice.util.request.MonitoringEndpointRequest;
import org.example.monitoringservice.util.validation.interfaces.ValidAccessToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/monitoring-endpoint")
@RequiredArgsConstructor
public class MonitoringEndpointController {
    private final MonitoringEndpointService monitoringEndpointService;

    @PostMapping
    public ResponseEntity<MonitoringEndpoint> createMonitoringEndpoint(@RequestBody MonitoringEndpointRequest monitoringEndpointRequest,
                                                                      @RequestHeader("ACCESS_TOKEN_HEADER_NAME") @ValidAccessToken String accessToken){
        return ResponseEntity.ok(monitoringEndpointService.createMonitoringEndpoint(monitoringEndpointRequest, accessToken));
    }

    @DeleteMapping("/{monitored-endpoint-id}")
    public ResponseEntity<?> deleteMonitoringEndpoint(@PathVariable("monitoring-endpoint-id") Long monitoredEndpointId,
                                                     @RequestHeader("ACCESS_TOKEN_HEADER_NAME") @ValidAccessToken String accessToken){
        try {
            monitoringEndpointService.deleteMonitoringEndpoint(monitoredEndpointId, accessToken);
            return new ResponseEntity<>("Monitoring Endpoint deleted", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Monitoring Endpoint not deleted because of " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<MonitoringEndpoint>> getMonitoredEndpointsForAccessToken(@RequestHeader("ACCESS_TOKEN_HEADER_NAME") @ValidAccessToken String accessToken){
        return ResponseEntity.ok(monitoringEndpointService.getMonitoringEndpointsByAccessToken(accessToken));
    }
}
