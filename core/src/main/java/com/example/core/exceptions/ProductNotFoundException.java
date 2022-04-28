package com.example.core.exceptions;

public class ProductNotFoundException extends BusinessException{

  private final Long id;

  public ProductNotFoundException(final Long id){
    super(Codes.PRODUCT_NOT_FOUND_EXCEPTION);
    this.id = id;
  }

  @Override
  public String getMessage(){
    return String.format("%s - %s", super.getMessage(), id);
  }

}
