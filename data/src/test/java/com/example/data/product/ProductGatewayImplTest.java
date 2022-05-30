package com.example.data.product;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.core.product.product.Product;
import com.example.data.product.entity.ProductEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductGatewayImplTest {

  @InjectMocks
  private ProductGatewayImpl gateway;

  @Mock
  private ProductRepository repository;

  private final Random rd = new Random();

  @Test
  void shouldListAllProducts(){
    when(repository.findAll()).thenReturn(buildProductsEntity());

    final List<Product> products = gateway.findProducts();
    assertEquals(products.size(), buildProductsEntity().size());
  }

  @Test
  void shouldGetProductById(){
    when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(buildProductEntity()));

    final Product product = gateway.findProductById(rd.nextLong());
    assertEquals(product.getName(), buildProduct().getName());
    assertEquals(product.getBusinessSegment(), buildProduct().getBusinessSegment());
  }

  @Test
  void shouldAddProduct(){
    when(repository.save(any())).thenReturn(buildProductEntity());

    final Product product = gateway.saveProduct(buildProduct());
    assertEquals(product.getName(), buildProductEntity().getName());
    assertEquals(product.getBusinessSegment(), buildProductEntity().getBusinessSegment());
  }

  @Test
  void shouldDeleteProduct(){
    final Long id = rd.nextLong();
    gateway.deleteProductById(id);
    verify(repository, times(1)).deleteById(id);
  }

  @Test
  void shouldUpdateProduct(){
    when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(buildProductEntity()));
    when(repository.save(any())).thenReturn(buildProductEntity());

    final Product updatedProduct = gateway.updateProduct(buildProduct());
    assertNotNull(updatedProduct);
  }

  @Test
  void shouldCheckIfProductExists(){
    when(repository.existsById(anyLong())).thenReturn(true);

    boolean exists = gateway.existsProduct(rd.nextLong());
    assertTrue(exists);
  }

  private List<ProductEntity> buildProductsEntity(){
    List<ProductEntity> products = new ArrayList<>();
    products.add(buildProductEntity());
    products.add(buildProductEntity());
    return products;
  }

  private ProductEntity buildProductEntity(){
    return ProductEntity.builder()
        .id(rd.nextLong())
        .name("Test Product")
        .businessSegment("Test Product")
        .build();
  }

  private Product buildProduct(){
    return Product.builder()
        .id(rd.nextLong())
        .name("Test Product")
        .businessSegment("Test Product")
        .build();
  }
}