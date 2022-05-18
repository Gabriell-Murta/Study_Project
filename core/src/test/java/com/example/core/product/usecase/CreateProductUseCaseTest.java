package com.example.core.product.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import com.example.core.exceptions.BusinessException.Codes;
import com.example.core.exceptions.CompanyNotFoundException;
import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import com.example.core.product.usecase.CreateProductUseCase.Request;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateProductUseCaseTest {

  @InjectMocks
  private CreateProductUseCase useCase;

  @Mock
  private ProductGateway productGateway;

  @Mock
  private CompanyGateway companyGateway;

  private final Random rd = new Random();

  @Test
  void shouldThrowExceptionWhenCompanyIsNotFoundInDataBase(){
    when(companyGateway.existsCompany(anyLong())).thenReturn(false);
    final Long id = rd.nextLong();
    final CompanyNotFoundException exception = assertThrows(CompanyNotFoundException.class, () -> useCase.execute(id, buildRequest()));
    assertEquals(Codes.COMPANY_NOT_FOUND_EXCEPTION.getCode(), exception.getCode());
    assertEquals("No company found with provided ID - " + id, exception.getMessage());
  }

  @Test
  void shouldCreateProductWhitSuccess(){
    when(companyGateway.existsCompany(anyLong())).thenReturn(true);
    when(companyGateway.findCompanyById(anyLong())).thenReturn(buildCompany());
    when(productGateway.saveProduct(any())).thenReturn(buildProduct());

    final Product productAfterUseCase = useCase.execute(anyLong(), buildRequest());
    assertEquals(buildProduct().getName(), productAfterUseCase.getName());
    assertEquals(buildProduct().getBusinessSegment(), productAfterUseCase.getBusinessSegment());
  }

  private CreateProductUseCase.Request buildRequest(){
    final CreateProductUseCase.Request request = new Request("Test Name","Business Segment Test");
    return request;
  }

  private Company buildCompany(){
    return Company.builder()
        .id(rd.nextLong())
        .name("Test Company")
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