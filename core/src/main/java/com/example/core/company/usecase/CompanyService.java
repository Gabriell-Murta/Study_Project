package com.example.core.company.usecase;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

  private final CompanyGateway companyGateway;

  @Autowired
  public CompanyService(CompanyGateway companyRepository) {
    this.companyGateway = companyRepository;
  }

  public List<Company> getCompany(){
    return companyGateway.findCompany();
  }

  public Company createCompany(Company company) {
    return companyGateway.saveCompany(company);
  }

  public void deleteCompany(Long id) {
    companyGateway.deleteCompanyById(id);
  }

  public Company updateCompany(Long id, Company companyUpdate) {
    Company company = companyGateway.findCompanyById(id);

    if(companyUpdate.getName() != null && !companyUpdate.getName().isEmpty()){
      company.setName(companyUpdate.getName());
    }

    companyGateway.saveCompany(company);
    return company;
  }
}
