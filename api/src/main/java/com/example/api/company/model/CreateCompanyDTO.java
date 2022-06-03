package com.example.api.company.model;

import com.example.api.product.model.CreateProductDTO;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCompanyDTO {

  @NotBlank private String name;
  @Valid private CreateProductDTO product;

}
