package com.example.core.product.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.example.core.company.company.Company;
import com.example.core.exceptions.BusinessException.Codes;
import com.example.core.exceptions.ProductNotFoundException;
import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import com.example.core.product.usecase.UpdateProductUseCase.Request;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateProductUseCaseTest {

  @InjectMocks
  private UpdateProductUseCase useCase;

  @Mock
  private ProductGateway productGateway;

  private final Random rd = new Random();

  @Test
  void shouldThrowExceptionWhenProductIsNotFoundInDatabase(){
    when(productGateway.existsProduct(anyLong())).thenReturn(false);
    final Long id = rd.nextLong();
    final ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> useCase.execute(id, buildRequest()));
    assertEquals(Codes.PRODUCT_NOT_FOUND_EXCEPTION.getCode(), exception.getCode());
    assertEquals("No Subsidiary Product found with provided ID - " + id, exception.getMessage());
  }

  @Test
  void shouldRunUseCaseAndReturn(){
    when(productGateway.existsProduct(anyLong())).thenReturn(true);
    when(productGateway.findProductById(anyLong())).thenReturn(buildProduct());
    when(productGateway.updateProduct(any())).thenReturn(buildProduct());

    final Product updatedProduct = useCase.execute(anyLong(), buildRequest());
    assertNotNull(updatedProduct);
  }

  private UpdateProductUseCase.Request buildRequest(){
    final UpdateProductUseCase.Request request = new Request("Test Name","Business Segment Test");
    return request;
  }

  private Product buildProduct(){
    return Product.builder()
        .id(rd.nextLong())
        .name("Test Product")
        .businessSegment("Test Product")
        .build();
  }
}