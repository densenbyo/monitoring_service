package org.example.monitoringservice.repository;

import org.example.monitoringservice.model.MonitoringResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoringResultDao extends JpaRepository<MonitoringResult, Long> {
}
