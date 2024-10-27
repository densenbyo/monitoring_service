package org.example.monitoringservice.util.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.monitoringservice.util.validation.interfaces.ValidEndpointUrl;
import org.apache.commons.validator.routines.UrlValidator;

public class ValidEndpointUrlValidator implements ConstraintValidator<ValidEndpointUrl, String> {
    @Override
    public void initialize(ValidEndpointUrl constraintAnnotation) {
    }

    @Override
    public boolean isValid(String url, ConstraintValidatorContext context) {
        String[] schemes = {"http","https"};
        UrlValidator urlValidator = new UrlValidator(schemes);

        if (url == null || url.isEmpty()) {
            return false;
        }

        return urlValidator.isValid(url);
    }
}
