package com.example.data.product.mapper;

import com.example.core.product.product.Product;
import com.example.data.product.entity.ProductEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.jpa.repository.JpaContext;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

  ProductEntity toEntity(Product productEntity, @Context JpaContext ctx);

  @Mapping(target = "company", ignore = true)
  Product fromEntity(ProductEntity productEntity, @Context JpaContext ctx);
}
