package com.csti.customer.commons.exceptions;


import com.csti.customer.commons.dto.RespResultDto;
import com.csti.customer.commons.enums.EResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> getObjectResponseEntity(Exception ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        String message = ex.getLocalizedMessage();
        if (!StringUtils.hasLength(message))
            message = EResponse.ERROR.getMessage();

        RespResultDto response = new RespResultDto();

        RespResultDto.Result result = new RespResultDto.Result();
        result.setCodigo(EResponse.ERROR.getCode());
        result.setDescripcion(message);
        result.setTipo(EResponse.ERROR.getType());
        response.setResultado(Collections.singletonList(result));

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAnyException(
            @NotNull Exception ex,
            WebRequest request) {
        return getObjectResponseEntity(ex);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(
            @NotNull BusinessException ex,
            WebRequest request) {
        return getObjectResponseEntity(ex);
    }

}