package com.example.core.product.usecase;

import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CreateProductUseCase {

  private final ProductGateway productGateway;

  public Product execute(Product product){ return productGateway.saveProduct(product); }
}
