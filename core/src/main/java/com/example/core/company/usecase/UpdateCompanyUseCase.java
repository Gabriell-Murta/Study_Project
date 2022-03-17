package com.example.core.company.usecase;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCompanyUseCase {

  private final CompanyGateway companyGateway;

  @Autowired
  public UpdateCompanyUseCase(CompanyGateway companyGateway) {
    this.companyGateway = companyGateway;
  }

  public Company execute(Long id, Company companyUpdate){
    Company company = companyGateway.findCompanyById(id);

    if(companyUpdate.getName() != null && !companyUpdate.getName().isEmpty()){
      company.setName(companyUpdate.getName());
    }

    companyGateway.saveCompany(company);
    return company;
  }
}
