package com.example.core.company.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ListCompaniesUseCaseTest {

  @InjectMocks
  private ListCompaniesUseCase useCase;

  @Mock
  private CompanyGateway companyGateway;

  private final Random rd = new Random();

  @Test
  void shouldListAllCompanies(){
    when(companyGateway.findCompanies()).thenReturn(buildCompanies());

    final List<Company> companies = useCase.execute();
    assertEquals(companies.size(), buildCompanies().size());
  }

  private List<Company> buildCompanies(){
    List<Company> companies = new ArrayList<>();
    companies.add(buildCompany());
    companies.add(buildCompany());
    return companies;
  }

  private Company buildCompany(){
    return Company.builder()
        .id(rd.nextLong())
        .name("Test Company")
        .build();
  }
}