package com.dc.java.back.end.exception.advice;

import com.dc.java.back.end.dto.ErrorDTO;
import com.dc.java.back.end.exception.ProductNotFoundException;
import com.dc.java.back.end.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice(basePackages = "com.santana.java.back.end.controller")
public class ShoppingControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDTO handleUserNotFound(ProductNotFoundException userNotFoundException) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setMessage("Produto não encontrado.");
        errorDTO.setTimestamp(new Date());
        return errorDTO;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorDTO handleUserNotFound(UserNotFoundException userNotFoundException) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setMessage("Usuário não encontrado.");
        errorDTO.setTimestamp(new Date());
        return errorDTO;
    }
}