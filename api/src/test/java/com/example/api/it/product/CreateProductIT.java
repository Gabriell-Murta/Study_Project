package com.example.api.it.product;

import com.example.api.config.IntegrationTest;
import com.example.api.product.model.ProductResponse;
import com.example.core.product.product.Product;
import com.example.data.company.CompanyRepository;
import com.example.data.company.entity.CompanyEntity;
import com.example.data.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.example.api.it.EntityUtil.createCompanyEntity;
import static com.example.api.it.RequestUtil.createProduct;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
public class CreateProductIT {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void shouldAddProduct() throws Exception{
    final CompanyEntity companyEntity = companyRepository.save(createCompanyEntity());

    final ResultActions result = mvc.perform(post("/api/v2/products/{id}", companyEntity.getId())
        .content(objectMapper.writeValueAsString(createProduct()))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("name"))
        .andExpect(jsonPath("$.businessSegment").value("businessSegment"));

    final String content = result.andReturn().getResponse().getContentAsString();
    final ProductResponse product = objectMapper.readValue(content, ProductResponse.class);

    assertTrue(productRepository.existsById(product.getId()));
  }
}
