package com.example.api.company.model;

import com.example.api.product.model.ProductResponse;
import java.util.Set;
import lombok.Data;

@Data
public class CompanyResponse {
  private Long id;
  private String name;
  private Set<ProductResponse> products;

}
