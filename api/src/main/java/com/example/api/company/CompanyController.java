package com.example.api.company;

import com.example.api.company.mapper.CompanyRequestMapper;
import com.example.api.company.mapper.CompanyResponseMapper;
import com.example.api.company.model.CompaniesResponse;
import com.example.api.company.model.CompanyResponse;
import com.example.api.company.model.CreateCompanyDTO;
import com.example.api.company.model.UpdateCompanyDTO;
import com.example.api.product.mapper.ProductRequestMapper;
import com.example.core.company.company.Company;
import com.example.core.company.usecase.CreateCompanyUseCase;
import com.example.core.company.usecase.DeleteCompanyUseCase;
import com.example.core.company.usecase.GetCompanyUseCase;
import com.example.core.company.usecase.ListCompaniesUseCase;
import com.example.core.company.usecase.UpdateCompanyUseCase;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v2/companies")
@RequiredArgsConstructor
public class CompanyController {

  private final ListCompaniesUseCase listCompaniesUseCase;
  private final CreateCompanyUseCase createCompanyUseCase;
  private final DeleteCompanyUseCase deleteCompanyUseCase;
  private final GetCompanyUseCase getCompanyUseCase;
  private final UpdateCompanyUseCase updateCompanyUseCase;
  private final CompanyResponseMapper mapper = Mappers.getMapper(CompanyResponseMapper.class);
  private final CompanyRequestMapper companyRequestMapper = Mappers.getMapper(CompanyRequestMapper.class);
  private final ProductRequestMapper productRequestMapper = Mappers.getMapper(ProductRequestMapper.class);

  @GetMapping
  public ResponseEntity<CompaniesResponse> listCompanies(){
    final List<Company> companies = listCompaniesUseCase.execute();
    final List<CompanyResponse> responses = companies.stream().map(mapper::toResponse).collect(Collectors.toList());
    return ResponseEntity.ok().body(new CompaniesResponse(responses));
  }

  @GetMapping("/{id}")
  public ResponseEntity<CompanyResponse> getCompany(@PathVariable Long id) {
    final Company company = getCompanyUseCase.execute(id);
    return ResponseEntity.ok(mapper.toResponse(company));
  }

  @PostMapping
  public ResponseEntity<CompanyResponse> createCompany(@RequestBody CreateCompanyDTO dto){
    final Company companyRequest = companyRequestMapper.toCompany(dto);
    final CreateCompanyUseCase.Request request = new CreateCompanyUseCase.Request(companyRequest);
    final Company company = createCompanyUseCase.execute(request);
    return ResponseEntity.ok(mapper.toResponse(company));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCompany(@PathVariable Long id){
    deleteCompanyUseCase.execute(id);
    return ResponseEntity.ok().build();
  }

  @PatchMapping("/{id}")
  public ResponseEntity<CompanyResponse> updateCompany(@PathVariable Long id, @RequestBody UpdateCompanyDTO dto){
    final UpdateCompanyUseCase.Request request = new UpdateCompanyUseCase.Request(dto.getName());
    final Company company = updateCompanyUseCase.execute(id, request);
    return ResponseEntity.ok(mapper.toResponse(company));
  }

}
