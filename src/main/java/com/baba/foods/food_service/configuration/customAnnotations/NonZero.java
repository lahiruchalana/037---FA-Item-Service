package com.baba.foods.food_service.configuration.customAnnotations;


import com.baba.foods.food_service.configuration.customAnnotations.validator.NonZeroValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NonZeroValidator.class)
public @interface NonZero {

    String message() default "Value must be non-zero and non-negative";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
