package com.example.data.company;

import com.example.core.company.company.Company;
import com.example.core.company.gateway.CompanyGateway;
import com.example.data.company.entity.CompanyEntity;
import com.example.data.company.mapper.CompanyEntityMapper;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CompanyGatewayImpl implements CompanyGateway {

  private final JpaContext jpaContext;
  private final CompanyRepository companyRepository;
  private final CompanyEntityMapper companyEntityMapper = Mappers.getMapper(CompanyEntityMapper.class);

  @Override
  @Transactional
  public List<Company> findCompanies() {
    final List<CompanyEntity> companyEntities = companyRepository.findAll();
    return  companyEntities.stream().map(Company -> companyEntityMapper.fromEntity(Company, jpaContext)).collect(Collectors.toList());
  }

  @Override
  @Transactional
  public Company getCompany(Long id){

    final CompanyEntity companyEntity = companyRepository.findById(id).get();
    return companyEntityMapper.fromEntity(companyEntity, jpaContext);
  }

  @Override
  @Transactional
  public Company saveCompany(Company company) {

    final CompanyEntity companyEntity = companyEntityMapper.toEntity(company, jpaContext);
    return companyEntityMapper.fromEntity(companyRepository.save(companyEntity), jpaContext);
  }

  @Override
  @Transactional
  public void deleteCompanyById(Long id) {

    companyRepository.deleteById(id);
  }

  @Override
  @Transactional
  public Company findCompanyById(Long id) {

    final CompanyEntity companyEntity = companyRepository.findById(id).get();
    return companyEntityMapper.fromEntity(companyEntity, jpaContext);
  }

  @Override
  @Transactional
  public Company updateCompany(Company company){
    final CompanyEntity companyEntity = companyRepository.findById(company.getId()).get();
    final CompanyEntity entity = updateCompanyEntity(companyEntity, company);
    final CompanyEntity updatedCompany = companyRepository.save(entity);
    return companyEntityMapper.fromEntity(updatedCompany, jpaContext);
  }

  private CompanyEntity updateCompanyEntity(final CompanyEntity companyEntity, final Company company){
    companyEntity.setName(company.getName());
    return companyEntity;
  }
}
