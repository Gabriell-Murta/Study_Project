package com.example.demo.company;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

  private final CompanyRepository companyRepository;

  @Autowired
  public CompanyService(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  public List<Company> getCompany(){
    return companyRepository.findAll();
  }

  public Company createCompany(Company company) {
    return companyRepository.save(company);
  }

  public void deleteCompany(Long id) {
    companyRepository.deleteById(id);
  }

  public Company updateCompany(Long id, Company companyUpdate) {
    Company company = companyRepository.findById(id).get();

    if(companyUpdate.getName() != null && !companyUpdate.getName().isEmpty()){
      company.setName(companyUpdate.getName());
    }

    companyRepository.save(company);
    return company;
  }
}
