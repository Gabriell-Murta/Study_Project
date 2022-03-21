package com.example.api.product;

import com.example.core.product.product.Product;
import com.example.core.product.usecase.AssignProductToCompanyUseCase;
import com.example.core.product.usecase.CreateProductUseCase;
import com.example.core.product.usecase.DeleteProductUseCase;
import com.example.core.product.usecase.ListProductsUseCase;
import com.example.core.product.usecase.UpdateProductUseCase;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v2/product")
public class ProductController {

  private final AssignProductToCompanyUseCase assignProductToCompany;
  private final CreateProductUseCase createProduct;
  private final DeleteProductUseCase deleteProduct;
  private final ListProductsUseCase listProductsUseCase;
  private final UpdateProductUseCase updateProduct;

  @GetMapping
  public List<Product> getProduct(){
    return listProductsUseCase.execute();
  }

  @PostMapping("/{productId}/company/{companyId}")
  Product assignProductToCompany(@PathVariable Long productId, @PathVariable Long companyId){
    return assignProductToCompany.execute(productId,companyId);
  }

  @PostMapping("/create")
  Product createProduct(@RequestBody Product product){
    return createProduct.execute(product);
  }

  @DeleteMapping("/delete/{id}")
  void deleteProduct(@PathVariable Long id) {
    deleteProduct.execute(id);
  }

  @PostMapping("/update/{id}")
  Product updateProduct(@PathVariable Long id, @RequestBody Product product){
    return updateProduct.execute(id, product);
  }

}
