package com.example.api.company.model;

import com.example.api.product.model.ProductResponse;
import java.util.List;
import lombok.Data;

@Data
public class CompanyResponse {
  private final Long id;
  private final String name;
  private final List<ProductResponse> products;

}
