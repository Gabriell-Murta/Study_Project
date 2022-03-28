package com.example.api.product.model.mapper;

import com.example.api.product.model.ProductResponse;
import com.example.core.product.product.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper {

  ProductResponse toResponse(Product product);

}
