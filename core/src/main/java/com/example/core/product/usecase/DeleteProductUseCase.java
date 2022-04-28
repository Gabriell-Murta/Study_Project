package com.example.core.product.usecase;

import com.example.core.exceptions.ProductNotFoundException;
import com.example.core.product.gateway.ProductGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DeleteProductUseCase {

  private final ProductGateway productGateway;

  public void execute(final Long id){

    if (!productGateway.existsProduct(id)){
      throw new ProductNotFoundException(id);
    }

    productGateway.deleteProductById(id);
  }

}
