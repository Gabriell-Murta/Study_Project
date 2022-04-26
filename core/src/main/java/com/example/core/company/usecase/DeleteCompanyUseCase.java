package com.example.core.company.usecase;

import com.example.core.company.gateway.CompanyGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DeleteCompanyUseCase {

  private final CompanyGateway companyGateway;

  public void execute(final Long id){ companyGateway.deleteCompanyById(id); }

}
