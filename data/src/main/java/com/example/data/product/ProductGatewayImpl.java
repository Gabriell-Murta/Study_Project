package com.example.data.product;

import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductGatewayImpl implements ProductGateway {

  private final ProductRepository productRepository;

  public ProductGatewayImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }


  @Override
  @Transactional
  public List<Product> findProduct() {

    return productRepository.findAll();
  }

  @Override
  @Transactional
  public Product saveProduct(Product product) {

    return productRepository.save(product);
  }

  @Override
  @Transactional
  public void deleteProductById(Long id) {

    productRepository.deleteById(id);
  }

  @Override
  @Transactional
  public Product findProductById(Long id) {

    if (productRepository.existsById(id)){
      return productRepository.findById(id).get();
    }
    return null;
  }
}
