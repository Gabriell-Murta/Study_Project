package com.example.api.product;

import com.example.api.product.model.CreateProductDTO;
import com.example.api.product.model.ProductResponse;
import com.example.api.product.model.ProductsResponse;
import com.example.api.product.model.UpdateProductDTO;
import com.example.api.product.mapper.ProductResponseMapper;
import com.example.core.product.product.Product;
import com.example.core.product.usecase.AssignProductToCompanyUseCase;
import com.example.core.product.usecase.CreateProductUseCase;
import com.example.core.product.usecase.CreateProductUseCase.Request;
import com.example.core.product.usecase.DeleteProductUseCase;
import com.example.core.product.usecase.ListProductsUseCase;
import com.example.core.product.usecase.UpdateProductUseCase;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v2/product")
@RequiredArgsConstructor
public class ProductController {

  private final AssignProductToCompanyUseCase assignProductToCompany;
  private final CreateProductUseCase createProduct;
  private final DeleteProductUseCase deleteProduct;
  private final ListProductsUseCase listProductsUseCase;
  private final UpdateProductUseCase updateProduct;
  private final ProductResponseMapper mapper = Mappers.getMapper(ProductResponseMapper.class);

  @GetMapping
  public ResponseEntity<ProductsResponse> getProduct(){
    final List<Product> products = listProductsUseCase.execute();
    final List<ProductResponse> responses = products.stream().map(mapper::toResponse).collect(Collectors.toList());
    return ResponseEntity.ok().body(new ProductsResponse(responses));
  }

  @PostMapping("/{productId}/company/{companyId}")
  public ResponseEntity<ProductResponse> assignProductToCompany(@PathVariable Long productId, @PathVariable Long companyId){
    final Product product = assignProductToCompany.execute(productId, companyId);
    return ResponseEntity.ok(mapper.toResponse(product));
  }

  @PostMapping("/create")
  public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductDTO dto){
    final CreateProductUseCase.Request request = new Request(dto.getName(), dto.getBusinessSegment());
    final Product product = createProduct.execute(request);
    return ResponseEntity.ok(mapper.toResponse(product));
  }

  @DeleteMapping("/delete/{id}")
  void deleteProduct(@PathVariable Long id) {
    deleteProduct.execute(id);
  }

  @PostMapping("/update/{id}")
  public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody UpdateProductDTO dto){
    final UpdateProductUseCase.Request request = new UpdateProductUseCase.Request(dto.getName());
    final Product product = updateProduct.execute(id, request);
    return ResponseEntity.ok(mapper.toResponse(product));
  }

}
