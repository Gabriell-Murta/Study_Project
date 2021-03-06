package com.example.api.member.model;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberDTO {

  @NotBlank private String name;
  @NotBlank private String document;
  @NotBlank private String documentType;
  @NotBlank private String businessSegment;

}
