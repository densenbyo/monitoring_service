package org.example.monitoringservice.util.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.monitoringservice.util.validation.interfaces.ValidEndpointName;

public class ValidEndpointNameValidator implements ConstraintValidator<ValidEndpointName, String> {
    @Override
    public void initialize(ValidEndpointName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (name == null || name.isEmpty()) {
            return false;
        }

        return name.matches("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$");
    }
}
