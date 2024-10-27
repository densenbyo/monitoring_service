package org.example.monitoringservice.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity(name = "application_monitoring_result")
@Table(name = "application_monitoring_result")
public class MonitoringResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dateTime;

    @Column(nullable = false)
    private Integer httpStatus;

    @Column(nullable = false)
    private String payload;

    @ManyToOne
    @JoinColumn(name = "endpoint_id", nullable = false)
    private MonitoringEndpoint endpoint;
}
