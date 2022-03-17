package com.example.core.product.usecase;

import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductUseCase {

  private final ProductGateway productGateway;

  @Autowired
  public UpdateProductUseCase(ProductGateway productGateway) {
    this.productGateway = productGateway;
  }

  public Product execute(Long id, Product productUpdate){
    Product product = productGateway.findProductById(id);

    if (productUpdate.getName() != null && !productUpdate.getName().isEmpty()){
      product.setName(productUpdate.getName());
    }

    productGateway.saveProduct(product);
    return product;
  }
}
