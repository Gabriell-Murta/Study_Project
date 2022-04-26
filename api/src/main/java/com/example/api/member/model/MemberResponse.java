package com.example.api.member.model;

import lombok.Data;

@Data
public class MemberResponse {

  private final Long id;
  private final String name;
  private final String document;
  private final String documentType;
  private final String businessSegment;
}
