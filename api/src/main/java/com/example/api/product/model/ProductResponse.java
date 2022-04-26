package com.example.api.product.model;

import lombok.Data;

@Data
public class ProductResponse {

  private final Long id;
  private final String name;
  private final String businessSegment;
}
