package org.example.monitoringservice.util.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.monitoringservice.util.validation.interfaces.ValidEndpointInterval;

public class ValidEndpointIntervalValidator implements ConstraintValidator<ValidEndpointInterval, Integer> {
    @Override
    public void initialize(ValidEndpointInterval constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer interval, ConstraintValidatorContext context) {
        return interval != null && interval > 0;
    }
}
