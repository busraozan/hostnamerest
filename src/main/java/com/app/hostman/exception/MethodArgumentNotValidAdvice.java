package com.app.hostman.exception;

import com.app.hostman.util.RestEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class MethodArgumentNotValidAdvice {

    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Map<RestEnum, Object> hostnameRequestNotValidHandler(MethodArgumentNotValidException ex) {
        Map<RestEnum,Object> map = new LinkedHashMap<>();
        map.put(RestEnum.status, "NOK");
        map.put(RestEnum.errors, ex.getBindingResult()
                .getFieldErrors().stream()
                .map( FieldError::getDefaultMessage)
                .collect(Collectors.toList()).toString());
        return map;
    }

    @ResponseBody
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Map<RestEnum, Object> hostnameNotReadableHandler(HttpMessageNotReadableException ex) {
        Map<RestEnum,Object> map = new LinkedHashMap<>();
        map.put(RestEnum.status, "NOK");
        map.put(RestEnum.errors, "Parametre değerleri uygun değil: " + ex.getCause());
        return map;
    }
}
