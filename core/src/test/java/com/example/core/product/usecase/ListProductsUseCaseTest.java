package com.example.core.product.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ListProductsUseCaseTest {

  @InjectMocks
  private ListProductsUseCase useCase;

  @Mock
  private ProductGateway productGateway;

  private final Random rd = new Random();

  @Test
  void shouldListAllProducts(){
    when(productGateway.findProducts()).thenReturn(buildProducts());

    final List<Product> products = useCase.execute();
    assertEquals(products.size(), buildProducts().size());
  }

  private List<Product> buildProducts(){
    List<Product> products = new ArrayList<>();
    products.add(buildProduct());
    products.add(buildProduct());
    return products;
  }

  private Product buildProduct(){
    return Product.builder()
        .id(rd.nextLong())
        .name("Test Product")
        .businessSegment("Test Product")
        .build();
  }

}