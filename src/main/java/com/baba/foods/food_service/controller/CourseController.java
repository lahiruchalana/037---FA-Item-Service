package com.baba.foods.food_service.controller;

import com.baba.foods.food_service.business.CourseService;
import com.baba.foods.food_service.dto.CourseDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/course")
@RequiredArgsConstructor
@Slf4j
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/send-or-update")
    public ServiceResponseDTO addOrUpdateCourse(
            @RequestBody CourseDTO courseDTO
    ) {
        log.info ("LOG :: CourseController addOrUpdateCourse()");
        return courseService.addOrUpdateCourse(courseDTO);
    }
}
