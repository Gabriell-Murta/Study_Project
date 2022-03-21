package com.example.core.company.usecase;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ListCompaniesUseCase {

  private final CompanyGateway companyGateway;

  public List<Company> execute(){ return companyGateway.findCompany(); }

}
