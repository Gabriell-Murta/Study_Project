package com.example.api.company.mapper;

import com.example.api.company.model.CompanyResponse;
import com.example.core.company.company.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyResponseMapper {

    CompanyResponse toResponse(Company company);

}
