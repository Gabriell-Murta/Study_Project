package com.example.api.company.model;

import com.example.api.product.model.CreateProductDTO;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCompanyDTO {

  @NotBlank private String name;
  @Valid private CreateProductDTO product;

}
