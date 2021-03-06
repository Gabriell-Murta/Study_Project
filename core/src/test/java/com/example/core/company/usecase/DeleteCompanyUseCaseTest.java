package com.example.core.company.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
class DeleteCompanyUseCaseTest {

  @InjectMocks
  private DeleteCompanyUseCase useCase;

  @Mock
  private CompanyGateway companyGateway;

  private final Random rd = new Random();

  @Test
  void shouldThrowExceptionWhenCompanyIsNotFoundInDatabase(){
    when(companyGateway.existsCompany(anyLong())).thenReturn(false);
    final Long id = rd.nextLong();
    final CompanyNotFoundException exception = assertThrows(CompanyNotFoundException.class, () -> useCase.execute(id));
    assertEquals(Codes.COMPANY_NOT_FOUND_EXCEPTION.getCode(), exception.getCode());
    assertEquals("No company found with provided ID - " + id, exception.getMessage());
  }

  @Test
  void shouldDeleteCompanyWithSuccess(){
    final Long id = rd.nextLong();
    when(companyGateway.existsCompany(id)).thenReturn(true);
    useCase.execute(id);

    verify(companyGateway, times(1)).deleteCompanyById(id);
  }

}