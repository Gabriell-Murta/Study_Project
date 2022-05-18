package com.example.core.company.usecase;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import com.example.core.exceptions.CompanyNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class GetCompanyUseCase {

  private final CompanyGateway companyGateway;

  public Company execute(final Long id){

    if (!companyGateway.existsCompany(id)){
      throw new CompanyNotFoundException(id);
    }
    return companyGateway.findCompanyById(id);
  }

}
