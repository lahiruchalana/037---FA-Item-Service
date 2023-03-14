package com.baba.foods.food_service.controller.controllconfig;

import com.baba.foods.food_service.dto.response.ServiceResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> responseBuilder( ServiceResponseDTO serviceResponseDTO ) {
        return getObjectResponseEntity(serviceResponseDTO, serviceResponseDTO.getMessage(), serviceResponseDTO.getCode(), serviceResponseDTO.getHttpStatus());
    }

    private static ResponseEntity<Object> getObjectResponseEntity(Object data, String message, String code, HttpStatus httpStatus) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        response.put("message", message);
        response.put("code", code);
        return new ResponseEntity<>(response, httpStatus);
    }
}
