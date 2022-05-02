package com.example.api.product.model;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateProductDTO {

  @NotBlank private String name;
  @NotBlank private String businessSegment;
}
