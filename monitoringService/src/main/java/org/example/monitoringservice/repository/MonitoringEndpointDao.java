package org.example.monitoringservice.repository;

import org.example.monitoringservice.model.MonitoringEndpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoringEndpointDao extends JpaRepository<MonitoringEndpoint, Long> {
}
