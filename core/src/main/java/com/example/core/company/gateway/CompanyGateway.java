package com.example.core.company.gateway;

import com.example.core.company.company.Company;
import java.util.List;

public interface CompanyGateway {

  List<Company> findCompany();

  Company saveCompany(Company company);

  void deleteCompanyById(Long id);

  Company findCompanyById(Long id);

}