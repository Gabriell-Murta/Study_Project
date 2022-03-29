package com.example.api.product.model;

import java.util.List;
import lombok.Data;

@Data
public class ProductsResponse {

  public final List<ProductResponse> products;

}
