package com.example.data.company;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Component
public class CompanyGatewayImpl implements CompanyGateway {

  private final CompanyRepository companyRepository;

  @Override
  @Transactional
  public List<Company> findCompany() {

    return companyRepository.findAll();
  }

  @Override
  @Transactional
  public Company saveCompany(Company company) {

    return companyRepository.save(company);
  }

  @Override
  @Transactional
  public void deleteCompanyById(Long id) {

    companyRepository.deleteById(id);
  }

  @Override
  @Transactional
  public Company findCompanyById(Long id) {

    if (companyRepository.existsById(id)){
        return companyRepository.findById(id).get();
    }
    return null;
  }
}
