package com.example.core.company.usecase;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CreateCompanyUseCase {

  private final CompanyGateway companyGateway;

  public Company execute(Company company){ return companyGateway.saveCompany(company); }

}