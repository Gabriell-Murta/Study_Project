package com.example.core.product.usecase;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AssignProductToCompanyUseCase {

  private final CompanyGateway companyGateway;
  private final ProductGateway productGateway;

  public Product execute(Long productId, Long companyId){
    Company company = companyGateway.findCompanyById(companyId);
    Product product = productGateway.findProductById(productId);

    product.setCompany(company);
    return productGateway.saveProduct(product);
  }
}
