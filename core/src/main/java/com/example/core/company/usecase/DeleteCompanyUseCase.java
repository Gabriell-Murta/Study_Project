package com.example.core.company.usecase;

import com.example.core.company.gateway.CompanyGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteCompanyUseCase {

  private final CompanyGateway companyGateway;

  @Autowired
  public DeleteCompanyUseCase(CompanyGateway companyGateway) {
    this.companyGateway = companyGateway;
  }

  public void execute(Long id){ companyGateway.deleteCompanyById(id); }

}
