package com.example.api.company.mapper;

import com.example.api.company.model.CreateCompanyDTO;
import com.example.api.product.mapper.ProductRequestMapper;
import com.example.core.company.company.Company;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(uses = ProductRequestMapper.class, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface CompanyRequestMapper {

    Company toCompany(CreateCompanyDTO dto);

}
