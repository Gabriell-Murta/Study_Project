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

  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }

  public Product updateProduct(Long id, Product productUpdate) {
    Product product = productRepository.findById(id).get();

    if(productUpdate.getName() != null && !productUpdate.getName().isEmpty()){
      product.setName(productUpdate.getName());
    }

    if(productUpdate.getBusinessSegment() != null && !productUpdate.getBusinessSegment().isEmpty()){
      product.setBusinessSegment(productUpdate.getBusinessSegment());
    }

    productRepository.save(product);
    return product;
  }
}
