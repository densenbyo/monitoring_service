package org.example.monitoringservice.util.validation.interfaces;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.monitoringservice.util.validation.ValidAccessTokenValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = ValidAccessTokenValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAccessToken {
    String message() default "Invalid access token";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
