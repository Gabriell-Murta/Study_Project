package com.example.api.company.model;

import com.example.api.product.model.CreateProductDTO;
import lombok.Data;

@Data
public class CreateCompanyDTO {

  private String name;
  private CreateProductDTO product;

}
