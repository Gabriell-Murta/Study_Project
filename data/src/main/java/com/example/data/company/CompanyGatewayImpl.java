package com.example.data.company;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CompanyGatewayImpl implements CompanyGateway {

  private final CompanyRepository companyRepository;

  public CompanyGatewayImpl(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  @Override
  public List<Company> findCompany() {

    return companyRepository.findAll();
  }

  @Override
  public Company saveCompany(Company company) {

    return companyRepository.save(company);
  }

  @Override
  public void deleteCompanyById(Long id) {

    companyRepository.deleteById(id);
  }

  @Override
  public Company findCompanyById(Long id) {

    if (companyRepository.existsById(id)){
        return companyRepository.findById(id).get();
    }
    return null;
  }
}
