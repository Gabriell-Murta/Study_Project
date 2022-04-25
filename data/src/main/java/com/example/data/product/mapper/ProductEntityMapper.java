package com.example.data.product.mapper;

import com.example.core.product.product.Product;
import com.example.data.member.mapper.MemberEntityMapper;
import com.example.data.product.entity.ProductEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.springframework.data.jpa.repository.JpaContext;

@Mapper(uses = MemberEntityMapper.class, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface ProductEntityMapper {

  ProductEntity toEntity(Product productEntity, @Context JpaContext ctx);

  @Mapping(target = "company", ignore = true)
  Product fromEntity(ProductEntity productEntity, @Context JpaContext ctx);
}
