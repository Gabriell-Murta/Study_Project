package com.example.core.company.usecase;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class GetCompanyUseCase {

  private final CompanyGateway companyGateway;

  public Company execute(Long id){
    return companyGateway.getCompany(id);
  }

}
