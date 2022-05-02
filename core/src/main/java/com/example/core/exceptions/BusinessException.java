package com.example.core.exceptions;

import java.util.Objects;

public abstract class BusinessException extends RuntimeException {
  protected final Codes code;

  public BusinessException(final Codes code) {
    super();
    Objects.requireNonNull(code);
    this.code = code;
  }

  public BusinessException(final Codes code, final Throwable throwable) {
    super(throwable);
    Objects.requireNonNull(code);
    this.code = code;
  }

  @Override
  public String getMessage() {
    return this.code.getMessage();
  }

  public long getCode() {
    return this.code.getCode();
  }

  public enum Codes {
    COMPANY_NOT_FOUND_EXCEPTION(4000, "No company found with provided ID"),

    PRODUCT_NOT_FOUND_EXCEPTION(4001, "No Subsidiary Product found with provided ID"),

    MEMBER_NOT_FOUND_EXCEPTION(4002, "No Member found with provided ID"),

    INVALID_COMPANY_EXCEPTION(4003, "CompanyName cannot be empty"),

    INVALID_PRODUCT_EXCEPTION(4004, "ProductName or BusinessSegment cannot be empty"),

    INVALID_MEMBER_EXCEPTION(4005, "MemberName, BusinessSegment, Document or DocumentType cannot be empty");

    private long code;
    private String message;

    Codes(final long code, final String message) {
      Objects.requireNonNull(message);
      this.code = code;
      this.message = message;
    }

    public long getCode() {
      return this.code;
    }

    public String getMessage() {
      return this.message;
    }
  }
}
