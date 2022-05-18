package com.example.data.product;

import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import com.example.data.product.entity.ProductEntity;
import com.example.data.product.mapper.ProductEntityMapper;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductGatewayImpl implements ProductGateway {

  private final JpaContext jpaContext;
  private final ProductRepository productRepository;
  private final ProductEntityMapper productEntityMapper = Mappers.getMapper(ProductEntityMapper.class);

  @Override
  @Transactional
  public List<Product> findProducts() {

    final List<ProductEntity> productEntities = productRepository.findAll();
    return productEntities.stream().map(Product -> productEntityMapper.fromEntity(Product, jpaContext)).collect(Collectors.toList());
  }

  @Override
  @Transactional
  public Product saveProduct(Product product) {

    final ProductEntity productEntity = productEntityMapper.toEntity(product, jpaContext);
    return productEntityMapper.fromEntity(productRepository.save(productEntity), jpaContext);
  }

  @Override
  @Transactional
  public void deleteProductById(Long id) {

    productRepository.deleteById(id);
  }

  @Override
  @Transactional
  public Product findProductById(Long id) {

    final ProductEntity productEntity = productRepository.findById(id).get();
    return productEntityMapper.fromEntity(productEntity, jpaContext);
  }

  @Override
  @Transactional
  public Product updateProduct(Product product){
    final ProductEntity productEntity = productRepository.findById(product.getId()).get();
    final ProductEntity entity = updateProductEntity(productEntity, product);
    final ProductEntity updatedProduct = productRepository.save(entity);
    return productEntityMapper.fromEntity(updatedProduct, jpaContext);
  }

  @Override
  @Transactional
  public boolean existsProduct(final Long id){
    final boolean exists = productRepository.existsById(id);
    return exists;
  }

  private ProductEntity updateProductEntity(final ProductEntity productEntity, final Product product){
    productEntity.setName(product.getName());
    productEntity.setBusinessSegment(product.getBusinessSegment());
    return productEntity;
  }
}
