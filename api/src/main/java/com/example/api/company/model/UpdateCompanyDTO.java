package com.example.api.company.model;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCompanyDTO {

  @NotBlank
  private String name;

}
