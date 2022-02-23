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

  public Company createCompany(String name) {
    Company test = new Company(name);
    return companyRepository.save(test);
  }
}
