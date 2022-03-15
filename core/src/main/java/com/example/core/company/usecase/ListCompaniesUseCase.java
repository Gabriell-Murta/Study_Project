package com.example.core.company.usecase;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListCompaniesUseCase {

  private final CompanyGateway companyGateway;

  @Autowired
  public ListCompaniesUseCase(CompanyGateway companyGateway) {
    this.companyGateway = companyGateway;
  }

  public List<Company> execute(){ return companyGateway.findCompany(); }

}
