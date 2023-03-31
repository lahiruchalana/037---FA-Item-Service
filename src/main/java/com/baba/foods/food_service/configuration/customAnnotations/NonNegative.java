package com.baba.foods.food_service.configuration.customAnnotations;

import com.baba.foods.food_service.configuration.customAnnotations.validator.NonNegativeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NonNegativeValidator.class)
public @interface NonNegative {
    String message() default "Value must be non-negative";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}