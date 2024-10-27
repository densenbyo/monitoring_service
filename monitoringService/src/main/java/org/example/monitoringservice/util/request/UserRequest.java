package org.example.monitoringservice.util.request;

import org.example.monitoringservice.util.validation.interfaces.ValidAccessToken;
import org.example.monitoringservice.util.validation.interfaces.ValidEmail;
import org.example.monitoringservice.util.validation.interfaces.ValidUsername;

public record UserRequest(@ValidUsername String username,
                          @ValidEmail String email,
                          @ValidAccessToken String accessToken) {}
