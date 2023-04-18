package com.baba.foods.food_service.business.impl;

import com.baba.foods.food_service.business.CourseService;
import com.baba.foods.food_service.dto.CourseDTO;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import com.baba.foods.food_service.entity.Course;
import com.baba.foods.food_service.mapper.CourseToResponseDTO;
import com.baba.foods.food_service.repository.CourseRepository;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.baba.foods.food_service.utility.Utility.*;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    @Description("Insert Course data or update Course data when pass the CourseId")
    @CacheEvict(value = "course", allEntries = true)
    public ServiceResponseDTO addOrUpdateCourse(CourseDTO courseDTO) {
        log.info ("LOG :: CourseServiceImpl addOrUpdateCourse()");
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: CourseServiceImpl addOrUpdateCourse() inside the try");
            Course course = new Course();
            course.setName(courseDTO.getName());
            course.setFoods(courseDTO.getFoods());
            course.setCreatedDate(courseDTO.getCreatedDate());
            course.setUpdatedDate(courseDTO.getUpdatedDate());
            if (courseDTO.getId() != null) {
                course.setId(courseDTO.getId());
            }
            Course courseSave = courseRepository.save(course);
            serviceResponseDTO.setData(CourseToResponseDTO.getResponseDTO(courseSave));
            serviceResponseDTO.setCode(STATUS_2000);
            serviceResponseDTO.setMessage(STATUS_SUCCESS);
            serviceResponseDTO.setHttpStatus(HttpStatus.OK);
            serviceResponseDTO.setDescription("Successfully saved the data!!!");
        } catch (Exception e) {
            log.info ("LOG :: CourseServiceImpl addOrUpdateCourse() inside the catch");
            log.warn(String.valueOf(e));
            serviceResponseDTO.setError(e);
            serviceResponseDTO.setMessage(STATUS_FAIL);
            serviceResponseDTO.setCode(STATUS_5000);
            serviceResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            serviceResponseDTO.setDescription(e.getMessage());
        }
        return serviceResponseDTO;
    }
}
