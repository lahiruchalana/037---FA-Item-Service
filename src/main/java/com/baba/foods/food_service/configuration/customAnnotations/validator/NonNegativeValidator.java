package com.baba.foods.food_service.configuration.customAnnotations.validator;

import com.baba.foods.food_service.configuration.customAnnotations.NonNegative;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NonNegativeValidator implements ConstraintValidator<NonNegative, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value == null || value >= 0;
    }
}