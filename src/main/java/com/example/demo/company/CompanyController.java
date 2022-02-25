package com.example.demo.company;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/company")
public class CompanyController {

  private final CompanyService companyService;

  @Autowired
  public CompanyController(CompanyService companyService) {
    this.companyService = companyService;
  }

  @GetMapping
  public List<Company> getCompany(){
      return companyService.getCompany();
  }

  @PostMapping("/create")
  Company createCompany(@RequestBody Company company){
    return companyService.createCompany(company);
  }

  @DeleteMapping("/delete/{id}")
  void deleteCompany(@PathVariable Long id){
    companyService.deleteCompany(id);
  }

  @PostMapping("/update/{id}")
  Company updateCompany(@PathVariable Long id, @RequestBody Company company){
    return companyService.updateCompany(id, company);
  }

}
