package com.example.core.product.usecase;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductGateway productGateway;
  private final CompanyGateway companyGateway;

  @Autowired
  public ProductService(ProductGateway productGateway,
      CompanyGateway companyGateway) {
    this.productGateway = productGateway;
    this.companyGateway = companyGateway;
  }

  public List<Product> getProduct(){
    return productGateway.findProduct();
  }

  public Product assignProductToCompany(Long productId, Long companyId) {
    Product product = productGateway.findProductById(productId);
    Company company = companyGateway.findCompanyById(companyId);
    product.assignCompany(company);
    return productGateway.saveProduct(product);
  }

  public Product createProduct(Product product) {
    return productGateway.saveProduct(product);
  }

  public void deleteProduct(Long id) {
    productGateway.deleteProductById(id);
  }

  public Product updateProduct(Long id, Product productUpdate) {
    Product product = productGateway.findProductById(id);

    if(productUpdate.getName() != null && !productUpdate.getName().isEmpty()){
      product.setName(productUpdate.getName());
    }

    if(productUpdate.getBusinessSegment() != null && !productUpdate.getBusinessSegment().isEmpty()){
      product.setBusinessSegment(productUpdate.getBusinessSegment());
    }

    productGateway.saveProduct(product);
    return product;
  }
}
