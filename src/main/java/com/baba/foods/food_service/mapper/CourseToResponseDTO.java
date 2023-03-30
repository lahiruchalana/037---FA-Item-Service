package com.baba.foods.food_service.mapper;

import com.baba.foods.food_service.dto.CourseDTO;
import com.baba.foods.food_service.entity.Course;

public class CourseToResponseDTO {

    public static CourseDTO getResponseDTO(Course course) {
        return CourseDTO.builder()
                .id(course.getId())
                .name(course.getName())
                .foods(course.getFoods())
                .createdDate(course.getCreatedDate())
                .updatedDate(course.getUpdatedDate())
                .build();
    }
}
