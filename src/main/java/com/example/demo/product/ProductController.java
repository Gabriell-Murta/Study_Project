package com.example.demo.product;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
    public List<Product> getProduct(){
      return productService.getProduct();
  }

  @PutMapping("/{productId}/company/{companyId}")
  Product assignProductToCompany(@PathVariable Long productId, @PathVariable Long companyId){
    return productService.assignProductToCompany(productId,companyId);
  }

}
