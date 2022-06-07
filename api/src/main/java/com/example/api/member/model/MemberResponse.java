package com.example.api.member.model;

import lombok.Data;

@Data
public class MemberResponse {

  private Long id;
  private String name;
  private String document;
  private String documentType;
  private String businessSegment;
}
