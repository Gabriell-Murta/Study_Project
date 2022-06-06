package com.example.api.it.product;

import com.example.api.config.IntegrationTest;
import com.example.api.product.model.ProductResponse;
import com.example.data.company.CompanyRepository;
import com.example.data.company.entity.CompanyEntity;
import com.example.data.product.ProductRepository;
import com.example.data.product.entity.ProductEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static com.example.api.it.EntityUtil.createCompanyEntity;
import static com.example.api.it.EntityUtil.createProductEntity;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
public class GetProductIT {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void  shouldGetProductById() throws Exception{
    final CompanyEntity companyEntity = companyRepository.save(createCompanyEntity());
    companyEntity.setProducts(List.of(createProductEntity(companyEntity)));

    final CompanyEntity savedCompany = companyRepository.save(companyEntity);
    final ProductEntity productEntity = savedCompany.getProducts().get(0);
    final ResultActions result = mvc.perform(get("/api/v2/products/{id}", productEntity.getId()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("Product Name"))
        .andExpect(jsonPath("$.businessSegment").value("Business Segment"));

    final String content = result.andReturn().getResponse().getContentAsString();
    final ProductResponse product = objectMapper.readValue(content, ProductResponse.class);

    assertNotNull(product);
  }

}
