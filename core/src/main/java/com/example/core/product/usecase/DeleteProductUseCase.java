package com.example.core.product.usecase;

import com.example.core.product.gateway.ProductGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DeleteProductUseCase {

  private final ProductGateway productGateway;

  public void execute(Long id){ productGateway.deleteProductById(id); }

}
