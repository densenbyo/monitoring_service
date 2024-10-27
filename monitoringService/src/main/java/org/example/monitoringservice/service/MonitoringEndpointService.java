package org.example.monitoringservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.monitoringservice.model.MonitoringEndpoint;
import org.example.monitoringservice.model.User;
import org.example.monitoringservice.repository.MonitoringEndpointDao;
import org.example.monitoringservice.repository.MonitoringResultDao;
import org.example.monitoringservice.repository.UserDao;
import org.example.monitoringservice.util.request.MonitoringEndpointRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MonitoringEndpointService {
    private final MonitoringEndpointDao monitoringEndpointDao;
    private final MonitoringResultDao monitoringResultDao;
    private final UserDao userDao;

    public MonitoringEndpoint createMonitoringEndpoint(MonitoringEndpointRequest monitoringEndpointRequest, String accessToken) {
        log.info("Creation of monitoring endpoint started.");
        if (accessToken == null || accessToken.isEmpty()) {
            String msg = "Monitoring endpoint couldn't be created with null or empty user accessToken.";
            log.error(msg);
            throw new IllegalArgumentException(msg);
        }

        Optional<User> optionalUser = userDao.findByAccessToken(accessToken);
        Optional<MonitoringEndpoint> optionalMonitoringEndpoint = monitoringEndpointDao.findByName(monitoringEndpointRequest.name());

        if (optionalUser.isEmpty()) {
            String msg = String.format("User with passed accessToken: %s couldn't be found. " +
                    "Rolling back monitoring endpoint creation.",
                    accessToken);
            log.error(msg);
            throw new IllegalArgumentException(msg);
        }

        if (optionalMonitoringEndpoint.isPresent()) {
            String msg = String.format("Monitoring endpoint with name: %s exists. " +
                    "Rolling back monitoring endpoint creation.",
                    monitoringEndpointRequest.name());
            log.error(msg);
            throw new IllegalArgumentException(msg);
        }

        MonitoringEndpoint monitoringEndpoint = MonitoringEndpoint.builder()
                .name(monitoringEndpointRequest.name())
                .url(monitoringEndpointRequest.url())
                .creationDate(monitoringEndpointRequest.creationDate())
                .owner(optionalUser.get())
                .monitoredInterval(monitoringEndpointRequest.interval())
                .build();

        //TODO create monitoring result and start task by MonitoringEndpoint status?
        return monitoringEndpointDao.save(monitoringEndpoint);
    }

    public void deleteMonitoringEndpoint(Long id, String accessToken) {
        log.info("Starting deletion of monitoring endpoint.");
        if (accessToken == null || accessToken.isEmpty()) {
            String msg = "Monitoring endpoint couldn't be deleted with null or empty user accessToken.";
            log.error(msg);
            throw new IllegalArgumentException(msg);
        }

        Optional<MonitoringEndpoint> optionalMonitoringEndpoint = monitoringEndpointDao.findById(id);

        if (optionalMonitoringEndpoint.isEmpty()) {
            String msg = String.format("Monitoring endpoint with passed id: %s couldn't be found. " +
                            "Rolling back monitoring endpoint deletion.",
                    id);
            log.error(msg);
            throw new IllegalArgumentException(msg);
        }

        //TODO deleted monitoring result and stop task
        monitoringEndpointDao.delete(optionalMonitoringEndpoint.get());
    }

    public List<MonitoringEndpoint> getMonitoringEndpointsByAccessToken(String accessToken) {
        if (accessToken == null || accessToken.isEmpty()) {
            String msg = "Monitoring endpoint couldn't be found with null or empty user accessToken.";
            log.error(msg);
            throw new IllegalArgumentException(msg);
        }

        return monitoringEndpointDao.findMonitoringEndpointsByOwnerAccessToken(accessToken);
    }
}
