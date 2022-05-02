package com.example.api.error;

import com.example.api.error.model.ErrorResponse;
import com.example.core.exceptions.BusinessException.Codes;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class ErrorHandlerControllerAdvice {

  private static final Map<String, Codes> FIELD_TO_ERROR_CODE_MAP = new ConcurrentHashMap() {};

  static {
    FIELD_TO_ERROR_CODE_MAP.put("companyName", Codes.INVALID_COMPANY_EXCEPTION);
    FIELD_TO_ERROR_CODE_MAP.put("product", Codes.INVALID_PRODUCT_EXCEPTION);
    FIELD_TO_ERROR_CODE_MAP.put("member", Codes.INVALID_MEMBER_EXCEPTION);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  public ResponseEntity<ErrorResponse> validateArgumentNotValid(final MethodArgumentNotValidException e) {
    final String errorField = e.getBindingResult().getFieldErrors().get(0).getField();

    final Codes code = FIELD_TO_ERROR_CODE_MAP.get(errorField);

    return ResponseEntity.badRequest().body(new ErrorResponse(code.getCode(), code.getMessage()));
  }

}
