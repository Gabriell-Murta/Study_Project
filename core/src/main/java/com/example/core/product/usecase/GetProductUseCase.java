package com.example.core.product.usecase;

import com.example.core.exceptions.ProductNotFoundException;
import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class GetProductUseCase {

  private final ProductGateway productGateway;

  public Product execute(final Long id) {

    if (!productGateway.existsProduct(id)){
      throw new ProductNotFoundException(id);
    }
    return productGateway.findProductById(id);
  }
}
