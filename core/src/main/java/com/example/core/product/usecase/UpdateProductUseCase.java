package com.example.core.product.usecase;

import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UpdateProductUseCase {

  private final ProductGateway productGateway;

  @RequiredArgsConstructor
  public static class Request{
    private final String name;
  }

  public Product execute(Long id, Request request){
    Product product = productGateway.findProductById(id);
    Product productUpdate = new Product(request.name);

    if (productUpdate.getName() != null && !productUpdate.getName().isEmpty()){
      product.setName(productUpdate.getName());
    }

    productGateway.saveProduct(product);
    return product;
  }
}
