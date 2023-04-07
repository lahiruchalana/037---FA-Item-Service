package com.baba.foods.food_service.controller;

import com.baba.foods.food_service.business.impl.TestService;
import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import com.baba.foods.food_service.entity.Test;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final TestService testService;

    @PostMapping("/save")
    public ServiceResponseDTO postTestData(
            @RequestBody Test test
            ) {
        log.info ("LOG :: TestController getTestData()");
        return testService.postTestData(test);
    }

    @GetMapping("/")
    public ServiceResponseDTO getTestData() {
        log.info ("LOG :: TestController getTestData()");
        return testService.getTestData();
    }
}
