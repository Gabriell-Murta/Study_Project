package com.example.core.exceptions;

public class MemberNotFoundException extends BusinessException{

  private final Long id;

  public MemberNotFoundException(final Long id){
    super(Codes.MEMBER_NOT_FOUND_EXCEPTION);
    this.id = id;
  }

  @Override
  public String getMessage(){
    return String.format("%s - %s", super.getMessage(), id);
  }

}
