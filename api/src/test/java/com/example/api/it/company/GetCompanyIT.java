package com.example.api.it.company;

import com.example.api.company.model.CompanyResponse;
import com.example.api.config.IntegrationTest;
import com.example.data.company.CompanyRepository;
import com.example.data.company.entity.CompanyEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.example.api.it.EntityUtil.createCompanyEntity;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
public class GetCompanyIT {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void shouldGetCompanyById() throws Exception{
    final CompanyEntity companyEntity = companyRepository.save(createCompanyEntity());

    final ResultActions result = mvc.perform(get("/api/v2/companies/{id}",companyEntity.getId()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("Company Name"));

    final String content = result.andReturn().getResponse().getContentAsString();
    final CompanyResponse company = objectMapper.readValue(content, CompanyResponse.class);

    assertNotNull(company);
  }
}
