package com.example.core.product.usecase;

import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CreateProductUseCase {

  private final ProductGateway productGateway;

  @RequiredArgsConstructor
  public static class Request{
    private final String name;
    private final String businessSegment;
  }

  public Product execute(final Request request){
    final Product product = new Product(request.name, request.businessSegment);
    return productGateway.saveProduct(product); }
}
