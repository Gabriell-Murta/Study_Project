package com.example.data.company.mapper;

import com.example.core.company.company.Company;
import com.example.data.company.entity.CompanyEntity;
import com.example.data.product.mapper.ProductEntityMapper;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.springframework.data.jpa.repository.JpaContext;

@Mapper(uses = ProductEntityMapper.class, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface CompanyEntityMapper {

  CompanyEntity toEntity(Company companyEntity, @Context JpaContext ctx);

  Company fromEntity(CompanyEntity companyEntity, @Context JpaContext ctx);
}
