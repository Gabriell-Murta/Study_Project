package com.example.core.exceptions;

public class CompanyNotFoundException extends BusinessException{

  private final Long id;

  public CompanyNotFoundException(final Long id){
    super(Codes.COMPANY_NOT_FOUND_EXCEPTION);
    this.id = id;
  }

  @Override
  public String getMessage(){
    return String.format("%s - %s", super.getMessage(), id);
  }

}
