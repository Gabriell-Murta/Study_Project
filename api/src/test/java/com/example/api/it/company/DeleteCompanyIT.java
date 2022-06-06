package com.example.api.it.company;

import static com.example.api.it.EntityUtil.createCompanyEntity;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.api.config.IntegrationTest;
import com.example.data.company.CompanyRepository;
import com.example.data.company.entity.CompanyEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

@IntegrationTest
public class DeleteCompanyIT {
  @Autowired
  private MockMvc mvc;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void shouldDeleteCompanyById() throws Exception{
    final CompanyEntity companyEntity = companyRepository.save(createCompanyEntity());

    mvc.perform(delete("/api/v2/companies/{id}",companyEntity.getId()))
        .andExpect(status().isOk());

    final Optional<CompanyEntity> opt = companyRepository.findById(companyEntity.getId());

    assertFalse(opt.isPresent());
  }

}
