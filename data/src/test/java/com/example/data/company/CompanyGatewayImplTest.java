package com.example.data.company;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.core.company.company.Company;
import com.example.data.company.entity.CompanyEntity;
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
class CompanyGatewayImplTest {

  @InjectMocks
  private CompanyGatewayImpl gateway;

  @Mock
  private CompanyRepository repository;

  private final Random rd = new Random();

  @Test
  void shouldListAllCompanies(){
    when(repository.findAll()).thenReturn(buildCompaniesEntity());

    final List<Company> companies = gateway.findCompanies();
    assertEquals(companies.size(), buildCompaniesEntity().size());
  }

  @Test
  void shouldGetCompanyById(){
    when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(buildCompanyEntity()));

    final Company company = gateway.findCompanyById(rd.nextLong());
    assertEquals(company.getName(), buildCompanyEntity().getName());
  }

  @Test
  void shouldAddCompany(){
    when(repository.save(any())).thenReturn(buildCompanyEntity());

    final Company company = gateway.saveCompany(buildCompany());
    assertEquals(company.getName(), buildCompanyEntity().getName());
  }

  @Test
  void shouldDeleteCompany(){
    gateway.deleteCompanyById(rd.nextLong());
    verify(repository, times(1)).deleteById(anyLong());
  }

  @Test
  void shouldUpdateCompany(){
    when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(buildCompanyEntity()));
    when(repository.save(any())).thenReturn(buildCompanyEntity());

    final Company updatedCompany = gateway.updateCompany(buildCompany());
    assertNotNull(updatedCompany);
  }

  @Test
  void shouldCheckIfCompanyExist(){
    when(repository.existsById(any())).thenReturn(true);
    boolean exists = gateway.existsCompany(rd.nextLong());
    assertTrue(exists);
  }

  private List<CompanyEntity> buildCompaniesEntity(){
    List<CompanyEntity> companies = new ArrayList<>();
    companies.add(buildCompanyEntity());
    companies.add(buildCompanyEntity());
    return companies;
  }

  private CompanyEntity buildCompanyEntity(){
    return CompanyEntity.builder()
        .id(rd.nextLong())
        .name("Test Company")
        .build();
  }

  private Company buildCompany(){
    return Company.builder()
        .id(rd.nextLong())
        .name("Test Company")
        .build();
  }

}