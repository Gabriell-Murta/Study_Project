package com.example.core.product.usecase;

import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ListProductsUseCase {

  private final ProductGateway productGateway;

  public List<Product> execute(){ return productGateway.findProduct(); }
}
