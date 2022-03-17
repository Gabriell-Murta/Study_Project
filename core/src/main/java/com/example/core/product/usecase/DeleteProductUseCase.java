package com.example.core.product.usecase;

import com.example.core.product.gateway.ProductGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductUseCase {

  private final ProductGateway productGateway;

  @Autowired
  public DeleteProductUseCase(ProductGateway productGateway) {
    this.productGateway = productGateway;
  }

  public void execute(Long id){ productGateway.deleteProductById(id); }

}
