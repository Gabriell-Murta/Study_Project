package com.example.core.product.usecase;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssignProductToCompanyUseCase {

  private final CompanyGateway companyGateway;
  private final ProductGateway productGateway;

  @Autowired
  public AssignProductToCompanyUseCase(
      CompanyGateway companyGateway, ProductGateway productGateway) {
    this.companyGateway = companyGateway;
    this.productGateway = productGateway;
  }

  public Product execute(Long productId, Long companyId){
    Company company = companyGateway.findCompanyById(companyId);
    Product product = productGateway.findProductById(productId);

    product.assignCompany(company);
    return productGateway.saveProduct(product);
  }
}
