package com.example.api.company;

import com.example.core.company.company.Company;
import com.example.core.company.usecase.CreateCompanyUseCase;
import com.example.core.company.usecase.DeleteCompanyUseCase;
import com.example.core.company.usecase.ListCompaniesUseCase;
import com.example.core.company.usecase.UpdateCompanyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v2/company")
@RequiredArgsConstructor
public class CompanyController {

  private final ListCompaniesUseCase listCompaniesUseCase;
  private final CreateCompanyUseCase createCompanyUseCase;
  private final DeleteCompanyUseCase deleteCompanyUseCase;
  private final UpdateCompanyUseCase updateCompanyUseCase;

  @GetMapping
  public List<Company> getCompany(){ return listCompaniesUseCase.execute(); }

  @PostMapping("/create")
  Company createCompany(@RequestBody Company company){
    return createCompanyUseCase.execute(company);
  }

  @DeleteMapping("/delete/{id}")
  void deleteCompany(@PathVariable Long id){
    deleteCompanyUseCase.execute(id);
  }

  @PostMapping("/update/{id}")
  Company updateCompany(@PathVariable Long id, @RequestBody Company company){
    return updateCompanyUseCase.execute(id, company);
  }

}
