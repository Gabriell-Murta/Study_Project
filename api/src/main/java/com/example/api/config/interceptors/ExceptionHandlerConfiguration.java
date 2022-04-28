package com.example.api.config.interceptors;

import com.example.api.config.response.BusinessExceptionResponseBuilder;
import com.example.core.exceptions.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Controller
@Slf4j
public class ExceptionHandlerConfiguration {

  @ExceptionHandler(RuntimeException.class)
  public @ResponseBody ResponseEntity exceptionHandler(final RuntimeException exception){
    //if(exception instanceof BusinessException){
      return new BusinessExceptionResponseBuilder((BusinessException) exception, HttpStatus.BAD_REQUEST).build();
    //}
  }
}
