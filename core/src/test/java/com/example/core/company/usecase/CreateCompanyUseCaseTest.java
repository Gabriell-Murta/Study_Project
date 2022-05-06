package com.example.core.company.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import com.example.core.company.usecase.CreateCompanyUseCase.Request;
import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateCompanyUseCaseTest {

  @InjectMocks
  private CreateCompanyUseCase useCase;

  @Mock
  private CompanyGateway companyGateway;

  @Mock
  private ProductGateway productGateway;

  private final Random rd = new Random();

  @Test
  void shouldCreateCompanyWhitSuccess(){
    when(companyGateway.saveCompany(any())).thenReturn(buildCompany());
    when(productGateway.saveProduct(any())).thenReturn(buildProduct());

    final Company companyAfterUseCase = useCase.execute(buildRequest());
    assertEquals(buildCompany().getName(), companyAfterUseCase.getName());
  }

  private CreateCompanyUseCase.Request buildRequest(){
    final CreateCompanyUseCase.Request request = new Request(buildCompany(), buildProduct());
    return request;
  }

  private Company buildCompany(){
    return Company.builder()
        .id(15L)
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