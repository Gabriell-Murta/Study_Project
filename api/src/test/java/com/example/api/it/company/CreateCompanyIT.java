package com.example.api.it.company;

import com.example.api.company.model.CompanyResponse;
import com.example.api.config.IntegrationTest;
import com.example.data.company.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.example.api.it.RequestUtil.createCompany;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@IntegrationTest
public class CreateCompanyIT {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void shouldAddCompany() throws Exception {
    final ResultActions result = mvc.perform(post("/api/v2/companies")
        .content(objectMapper.writeValueAsString(createCompany()))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("name"));

    final String content = result.andReturn().getResponse().getContentAsString();
    final CompanyResponse company = objectMapper.readValue(content, CompanyResponse.class);

    assertTrue(companyRepository.existsById(company.getId()));
  }

}
