package org.example.monitoringservice.util.request;

import org.example.monitoringservice.util.validation.ValidAccessToken;
import org.example.monitoringservice.util.validation.ValidEmail;
import org.example.monitoringservice.util.validation.ValidUsername;

public record UserRequest(@ValidUsername String username,
                          @ValidEmail String email,
                          @ValidAccessToken String accessToken) {}
