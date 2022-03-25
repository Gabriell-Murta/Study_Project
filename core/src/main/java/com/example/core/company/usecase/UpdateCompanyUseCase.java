package com.example.core.company.usecase;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UpdateCompanyUseCase {

  private final CompanyGateway companyGateway;

  @RequiredArgsConstructor
  public static class Request{

    private final String name;

  }

  public Company execute(Long id, Request request){
    Company company = companyGateway.findCompanyById(id);
    Company companyUpdate = new Company(request.name);

    if(companyUpdate.getName() != null && !companyUpdate.getName().isEmpty()){
      company.setName(companyUpdate.getName());
    }

    companyGateway.saveCompany(company);
    return company;
  }
}
