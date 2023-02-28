package com.example.item_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponseDTO implements Serializable {

    Object data;
    Object error;
    Object message;
    String code;
    HttpStatus httpStatus;
    String description;

    public ServiceResponseDTO(Object data, Object error, Object message, String code, HttpStatus httpStatus, String description) {
        this.data = data;
        this.error = error;
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
        this.description = description;
    }
}
