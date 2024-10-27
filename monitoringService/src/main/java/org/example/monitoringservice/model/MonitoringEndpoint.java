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
@Entity(name = "application_monitoring_endpoint")
@Table(name = "application_monitoring_endpoint")
public class MonitoringEndpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column(nullable = false)
    private LocalDate lastCheckDate;

    @Column(nullable = false)
    private Integer monitoredInterval;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;
}
