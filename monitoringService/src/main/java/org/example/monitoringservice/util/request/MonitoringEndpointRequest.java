package org.example.monitoringservice.util.request;

import org.example.monitoringservice.util.validation.interfaces.ValidAccessToken;
import org.example.monitoringservice.util.validation.interfaces.ValidEndpointInterval;
import org.example.monitoringservice.util.validation.interfaces.ValidEndpointName;
import org.example.monitoringservice.util.validation.interfaces.ValidEndpointUrl;

import java.time.LocalDate;

public record MonitoringEndpointRequest(@ValidEndpointName String name,
                                        @ValidEndpointUrl String url,
                                        LocalDate creationDate,
                                        @ValidEndpointInterval int interval) {
}
