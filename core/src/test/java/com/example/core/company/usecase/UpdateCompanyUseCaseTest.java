package com.example.core.company.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import com.example.core.exceptions.BusinessException.Codes;
import com.example.core.exceptions.CompanyNotFoundException;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateCompanyUseCaseTest {

  @InjectMocks
  private UpdateCompanyUseCase useCase;

  @Mock
  private CompanyGateway companyGateway;

  private final Random rd = new Random();

  @Test
  void shouldThrowExceptionWhenCompanyIsNotFoundInDatabase(){
    when(companyGateway.existsCompany(anyLong())).thenReturn(false);
    final Long id = rd.nextLong();
    final UpdateCompanyUseCase.Request request = buildRequest();
    final CompanyNotFoundException exception = assertThrows(CompanyNotFoundException.class, () -> useCase.execute(id, request));
    assertEquals(Codes.COMPANY_NOT_FOUND_EXCEPTION.getCode(), exception.getCode());
    assertEquals("No company found with provided ID - " + id, exception.getMessage());
  }

  @Test
  void shouldRunUseCaseAndReturn(){
    final Long id = rd.nextLong();
    final Company company = buildCompany(id);
    when(companyGateway.existsCompany(id)).thenReturn(true);
    when(companyGateway.findCompanyById(id)).thenReturn(company);
    when(companyGateway.updateCompany(any())).thenReturn(company);

    final UpdateCompanyUseCase.Request request = buildRequest();
    final Company updatedCompany = useCase.execute(id, request);

    assertNotNull(updatedCompany);
  }

  private UpdateCompanyUseCase.Request buildRequest(){
    final UpdateCompanyUseCase.Request request = new UpdateCompanyUseCase.Request("Another Name");
    return request;
  }

  private Company buildCompany(Long id){
    return Company.builder()
                  .id(id)
                  .name("Test Company")
                  .build();
  }
}