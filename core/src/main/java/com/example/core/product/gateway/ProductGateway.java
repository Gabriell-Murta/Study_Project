package com.example.core.product.gateway;

import com.example.core.product.product.Product;
import java.util.List;

public interface ProductGateway {

  List<Product> findProduct();

  Product saveProduct(Product product);

  void deleteProductById(Long id);

  Product findProductById(Long id);

}
