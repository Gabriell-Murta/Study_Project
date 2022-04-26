package com.example.core.product.usecase;

import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import com.example.core.utils.ValidationHelper;
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
    private final String businessSegment;
  }

  public Product execute(final Long id, final Request request){
    Product product = productGateway.findProductById(id);
    final Product productUpdate = new Product(request.name, request.businessSegment);

    if (ValidationHelper.fieldHasValidValue(productUpdate.getName())){
      product.setName(productUpdate.getName());
    }

    if (ValidationHelper.fieldHasValidValue(productUpdate.getBusinessSegment())){
      product.setBusinessSegment(productUpdate.getBusinessSegment());
    }

    productGateway.updateProduct(product);
    return product;
  }
}
