package com.baba.foods.food_service.business.impl;

import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import com.baba.foods.food_service.entity.Food;
import com.baba.foods.food_service.entity.Test;
import com.baba.foods.food_service.repository.TestRepo;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.baba.foods.food_service.utility.Utility.*;
import static com.baba.foods.food_service.utility.Utility.STATUS_5000;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestService {

    private final TestRepo testRepo;

    @Description("Post test data")
    @CacheEvict(key = "222", value = "location")
    public ServiceResponseDTO postTestData(Test test) {
        log.info ("LOG :: TestService postTestData()");
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: TestService postTestData() inside the try");
            Test tests = testRepo.save(test);
            serviceResponseDTO.setData(tests);
            serviceResponseDTO.setCode(STATUS_2000);
            serviceResponseDTO.setMessage(STATUS_SUCCESS);
            serviceResponseDTO.setHttpStatus(HttpStatus.CREATED);
            serviceResponseDTO.setDescription("Successfully posted the data!!!");
        } catch (Exception e) {
            log.warn ("LOG :: TestService postTestData() inside the catch");
            log.warn(String.valueOf(e));
            serviceResponseDTO.setError(e);
            serviceResponseDTO.setMessage(STATUS_FAIL);
            serviceResponseDTO.setCode(STATUS_5000);
            serviceResponseDTO.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            serviceResponseDTO.setDescription(e.getMessage());
        }
        return serviceResponseDTO;
    }

    @Description("Get test data")
    @Cacheable(key = "222", value = "location")
    public ServiceResponseDTO getTestData() {
        log.info ("LOG :: TestService getTestData()");
        ServiceResponseDTO serviceResponseDTO = new ServiceResponseDTO();
        try {
            log.info ("LOG :: TestService getTestData() inside the try");
            List<Test> tests = testRepo.findAll();
            serviceResponseDTO.setData(tests);
            serviceResponseDTO.setCode(STATUS_2000);
            serviceResponseDTO.setMessage(STATUS_SUCCESS);
            serviceResponseDTO.setHttpStatus(HttpStatus.OK);
            serviceResponseDTO.setDescription("Successfully received the data!!!");
        } catch (Exception e) {
            log.warn ("LOG :: TestService getTestData() inside the catch");
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
