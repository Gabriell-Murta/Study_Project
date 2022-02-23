package com.example.demo.product;

import com.example.demo.company.Company;
import com.example.demo.company.CompanyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;
  private final CompanyRepository companyRepository;

  @Autowired
  public ProductService(ProductRepository productRepository,
      CompanyRepository companyRepository) {
    this.productRepository = productRepository;
    this.companyRepository = companyRepository;
  }

  public List<Product> getProduct(){
    return productRepository.findAll();
  }

  public Product assignProductToCompany(Long productId, Long companyId) {
    Product product = productRepository.findById(productId).get();
    Company company = companyRepository.findById(companyId).get();
    product.assignCompany(company);
    return productRepository.save(product);
  }
}
