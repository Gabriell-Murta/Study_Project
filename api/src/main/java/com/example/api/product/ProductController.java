package com.example.api.product;

import com.example.core.product.product.Product;
import com.example.core.product.usecase.ProductService;
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
@RequestMapping(path = "api/v2/product")
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

  @PostMapping("/{productId}/company/{companyId}")
  Product assignProductToCompany(@PathVariable Long productId, @PathVariable Long companyId){
    return productService.assignProductToCompany(productId,companyId);
  }

  @PostMapping("/create")
  Product createProduct(@RequestBody Product product){
    return productService.createProduct(product);
  }

  @DeleteMapping("/delete/{id}")
  void deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
  }

  @PostMapping("/update/{id}")
  Product updateProduct(@PathVariable Long id, @RequestBody Product product){
    return productService.updateProduct(id, product);
  }

}
