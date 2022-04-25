package com.example.api.member.model;

import lombok.Data;

@Data
public class UpdateMemberDTO {

  private String name;
  private String document;
  private String documentType;
  private String businessSegment;
}
