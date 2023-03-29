package com.baba.foods.food_service.business;

import com.baba.foods.food_service.dto.CookingMethodDTO;
import com.baba.foods.food_service.dto.CourseDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;

public interface CourseService {

    ServiceResponseDTO addOrUpdateCourse(CourseDTO courseDTO);

}
