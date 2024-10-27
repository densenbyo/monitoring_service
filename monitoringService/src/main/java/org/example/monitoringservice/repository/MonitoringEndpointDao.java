package org.example.monitoringservice.repository;

import org.example.monitoringservice.model.MonitoringEndpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MonitoringEndpointDao extends JpaRepository<MonitoringEndpoint, Long> {
    Optional<MonitoringEndpoint> findByName(String name);
    List<MonitoringEndpoint> findMonitoringEndpointsByOwnerAccessToken(String accessToken);
}
