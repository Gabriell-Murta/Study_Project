package com.example.api.member.model;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateMemberDTO {

  @NotBlank private String name;
  @NotBlank private String document;
  @NotBlank private String documentType;
  @NotBlank private String businessSegment;

}
