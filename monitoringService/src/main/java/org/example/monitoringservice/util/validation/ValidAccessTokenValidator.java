package org.example.monitoringservice.util.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.monitoringservice.util.validation.interfaces.ValidAccessToken;

public class ValidAccessTokenValidator implements ConstraintValidator<ValidAccessToken, String> {
    @Override
    public void initialize(ValidAccessToken constraintAnnotation) {
    }

    @Override
    public boolean isValid(String accessToken, ConstraintValidatorContext context) {
        if (accessToken == null || accessToken.isEmpty()) {
            return true;
        }

        return accessToken.matches("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$");
    }
}
