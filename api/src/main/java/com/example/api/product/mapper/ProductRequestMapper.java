package com.example.api.product.mapper;

import com.example.api.product.model.CreateProductDTO;
import com.example.core.product.product.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper {

    Product toProduct(CreateProductDTO dto);

}
