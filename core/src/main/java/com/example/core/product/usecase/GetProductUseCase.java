package com.example.core.product.usecase;

import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class GetProductUseCase {

  private final ProductGateway productGateway;

  public Product execute(final Long id) {
    return productGateway.getProduct(id);
  }
}
