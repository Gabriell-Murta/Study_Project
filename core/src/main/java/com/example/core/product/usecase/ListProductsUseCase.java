package com.example.core.product.usecase;

import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListProductsUseCase {

  private final ProductGateway productGateway;

  @Autowired
  public ListProductsUseCase(ProductGateway productGateway) {
    this.productGateway = productGateway;
  }

  public List<Product> execute(){ return productGateway.findProduct(); }
}
