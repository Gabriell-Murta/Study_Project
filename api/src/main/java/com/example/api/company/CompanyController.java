package com.example.api.company;

import com.example.api.company.mapper.CompanyResponseMapper;
import com.example.api.company.model.CompaniesResponse;
import com.example.api.company.model.CompanyResponse;
import com.example.api.company.model.CreateCompanyDTO;
import com.example.api.company.model.UpdateCompanyDTO;
import com.example.core.company.company.Company;
import com.example.core.company.usecase.CreateCompanyUseCase;
import com.example.core.company.usecase.DeleteCompanyUseCase;
import com.example.core.company.usecase.ListCompaniesUseCase;
import com.example.core.company.usecase.UpdateCompanyUseCase;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
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
  private final CompanyResponseMapper mapper = Mappers.getMapper(CompanyResponseMapper.class);

  @GetMapping
  public ResponseEntity<CompaniesResponse> getCompany(){
    final List<Company> companies = listCompaniesUseCase.execute();
    final List<CompanyResponse> responses = companies.stream().map(mapper::toResponse).collect(Collectors.toList());
    return ResponseEntity.ok().body(new CompaniesResponse(responses));
  }

  @PostMapping("/create")
  public ResponseEntity<CompanyResponse> createCompany(@RequestBody CreateCompanyDTO dto){
    final CreateCompanyUseCase.Request request = new CreateCompanyUseCase.Request(dto.getName());
    final Company company = createCompanyUseCase.execute(request);
    return ResponseEntity.ok(mapper.toResponse(company));
  }

  @DeleteMapping("/delete/{id}")
  void deleteCompany(@PathVariable Long id){
    deleteCompanyUseCase.execute(id);
  }

  @PostMapping("/update/{id}")
  public ResponseEntity<CompanyResponse> updateCompany(@PathVariable Long id, @RequestBody UpdateCompanyDTO dto){
    final UpdateCompanyUseCase.Request request = new UpdateCompanyUseCase.Request(dto.getName());
    final Company company = updateCompanyUseCase.execute(id, request);
    return ResponseEntity.ok(mapper.toResponse(company));
  }

}
