package com.example.core.company.usecase;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ListCompaniesUseCase {

  private final CompanyGateway companyGateway;

  public List<Company> execute(){ return companyGateway.findCompany(); }

}
