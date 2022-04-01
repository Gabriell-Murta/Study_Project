package com.example.core.company.usecase;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import com.example.core.product.product.Product;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CreateCompanyUseCase {

  private final CompanyGateway companyGateway;

  @RequiredArgsConstructor
  public static class Request{
    private final Company company;
  }

  public Company execute(final Request request){
    final Company company = request.company;
    return companyGateway.saveCompany(company);
  }

}
