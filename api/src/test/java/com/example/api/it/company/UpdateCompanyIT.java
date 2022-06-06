package com.example.api.it.company;

import static com.example.api.it.EntityUtil.createCompanyEntity;
import static com.example.api.it.RequestUtil.createUpdateCompanyDTO;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.api.company.model.CompanyResponse;
import com.example.api.config.IntegrationTest;
import com.example.data.company.CompanyRepository;
import com.example.data.company.entity.CompanyEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@IntegrationTest
public class UpdateCompanyIT {
  @Autowired
  private MockMvc mvc;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void shouldUpdateCompany() throws Exception {
    final CompanyEntity companyEntity = companyRepository.save(createCompanyEntity());

    final ResultActions result = mvc.perform(patch("/api/v2/companies/{id}", companyEntity.getId())
            .content(objectMapper.writeValueAsString(createUpdateCompanyDTO()))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("Updated Name"));

    final String content = result.andReturn().getResponse().getContentAsString();
    final CompanyResponse company = objectMapper.readValue(content, CompanyResponse.class);

    assertNotEquals(company.getName(), "name");
  }
}
