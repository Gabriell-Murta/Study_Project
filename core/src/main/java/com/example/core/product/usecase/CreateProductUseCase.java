package com.example.core.product.usecase;

import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProductUseCase {

  private final ProductGateway productGateway;

  @Autowired
  public CreateProductUseCase(ProductGateway productGateway) {
    this.productGateway = productGateway;
  }

  public Product execute(Product product){ return productGateway.saveProduct(product); }
}
