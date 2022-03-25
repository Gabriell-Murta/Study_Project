package com.example.core.company.usecase;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CreateCompanyUseCase {

  private final CompanyGateway companyGateway;

  @RequiredArgsConstructor
  public static class Request{
    private final String name;
  }

  public Company execute(final Request request){
    final Company company = new Company(request.name);
    return companyGateway.saveCompany(company);
  }

}
