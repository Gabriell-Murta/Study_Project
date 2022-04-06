package com.example.core.company.usecase;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CreateCompanyUseCase {

  private final CompanyGateway companyGateway;
  private final ProductGateway productGateway;

  @RequiredArgsConstructor
  public static class Request{
    private final Company company;
    private final Product product;
  }

  public Company execute(final Request request){
    final Company company = request.company;
    final Product product = request.product;
    final Company createdCompany = companyGateway.saveCompany(company);
    final Product productCreated = new Product(product.getName(), product.getBusinessSegment(), createdCompany);
    productGateway.saveProduct(productCreated);
    return createdCompany;
  }

}
