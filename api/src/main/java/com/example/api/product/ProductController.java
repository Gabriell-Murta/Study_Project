package com.example.api.product;

import com.example.api.product.model.CreateProductDTO;
import com.example.api.product.model.ProductResponse;
import com.example.api.product.model.ProductsResponse;
import com.example.api.product.model.UpdateProductDTO;
import com.example.api.product.mapper.ProductResponseMapper;
import com.example.core.product.product.Product;
import com.example.core.product.usecase.CreateProductUseCase;
import com.example.core.product.usecase.CreateProductUseCase.Request;
import com.example.core.product.usecase.DeleteProductUseCase;
import com.example.core.product.usecase.GetProductUseCase;
import com.example.core.product.usecase.ListProductsUseCase;
import com.example.core.product.usecase.UpdateProductUseCase;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v2/products")
@RequiredArgsConstructor
public class ProductController {

  private final CreateProductUseCase createProduct;
  private final DeleteProductUseCase deleteProduct;
  private final GetProductUseCase getProductUseCase;
  private final ListProductsUseCase listProductsUseCase;
  private final UpdateProductUseCase updateProduct;
  private final ProductResponseMapper mapper = Mappers.getMapper(ProductResponseMapper.class);

  @GetMapping
  public ResponseEntity<ProductsResponse> listProducts(){
    final List<Product> products = listProductsUseCase.execute();
    final List<ProductResponse> responses = products.stream().map(mapper::toResponse).collect(Collectors.toList());
    return ResponseEntity.ok().body(new ProductsResponse(responses));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id){
    final Product product = getProductUseCase.execute(id);
    return ResponseEntity.ok(mapper.toResponse(product));
  }


  @PostMapping("/{id}")
  public ResponseEntity<ProductResponse> createProduct(@PathVariable Long id, @RequestBody CreateProductDTO dto){
    final CreateProductUseCase.Request request = new Request(dto.getName(), dto.getBusinessSegment());
    final Product product = createProduct.execute(id, request);
    return ResponseEntity.ok(mapper.toResponse(product));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    deleteProduct.execute(id);
    return ResponseEntity.ok().build();
  }

  @PatchMapping("/{id}")
  public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody UpdateProductDTO dto){
    final UpdateProductUseCase.Request request = new UpdateProductUseCase.Request(dto.getName(), dto.getBusinessSegment());
    final Product product = updateProduct.execute(id, request);
    return ResponseEntity.ok(mapper.toResponse(product));
  }

}
