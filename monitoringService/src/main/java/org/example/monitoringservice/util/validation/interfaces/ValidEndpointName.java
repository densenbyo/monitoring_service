package org.example.monitoringservice.util.validation.interfaces;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.monitoringservice.util.validation.ValidAccessTokenValidator;
import org.example.monitoringservice.util.validation.ValidEndpointNameValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = ValidEndpointNameValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEndpointName {
    String message() default "Invalid name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
