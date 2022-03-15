package com.example.core.company.usecase;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCompanyUseCase {

  private final CompanyGateway companyGateway;

  @Autowired
  public CreateCompanyUseCase(CompanyGateway companyGateway) {
    this.companyGateway = companyGateway;
  }

  public Company execute(Company company){ return companyGateway.saveCompany(company); }

}
