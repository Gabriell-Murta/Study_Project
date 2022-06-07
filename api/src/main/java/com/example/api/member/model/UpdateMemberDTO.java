package com.example.api.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMemberDTO {

  private String name;
  private String document;
  private String documentType;
  private String businessSegment;
}
