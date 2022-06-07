package com.example.api.it.member;

import static com.example.api.it.EntityUtil.createCompanyEntity;
import static com.example.api.it.EntityUtil.createMemberEntity;
import static com.example.api.it.EntityUtil.createProductEntity;
import static com.example.api.it.RequestUtil.createUpdatedMember;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.api.config.IntegrationTest;
import com.example.api.member.model.MemberResponse;
import com.example.data.company.CompanyRepository;
import com.example.data.company.entity.CompanyEntity;
import com.example.data.member.MemberRepository;
import com.example.data.member.entity.MemberEntity;
import com.example.data.product.ProductRepository;
import com.example.data.product.entity.ProductEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@IntegrationTest
public class UpdateMemberIT {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private MemberRepository memberRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void shouldUpdateMember() throws Exception{
    final CompanyEntity companyEntity = companyRepository.save(createCompanyEntity());
    companyEntity.setProducts(List.of(createProductEntity(companyEntity)));

    final CompanyEntity savedCompany = companyRepository.save(companyEntity);
    final ProductEntity productEntity = savedCompany.getProducts().get(0);
    productEntity.setMembers(List.of(createMemberEntity(productEntity)));

    final ProductEntity savedProduct = productRepository.save(productEntity);
    final MemberEntity memberEntity = savedProduct.getMembers().get(0);

    final ResultActions result = mvc.perform(patch("/api/v2/members/{id}", memberEntity.getId())
            .content(objectMapper.writeValueAsString(createUpdatedMember()))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("Updated Name"))
        .andExpect(jsonPath("$.document").value("Updated Document"))
        .andExpect(jsonPath("$.documentType").value("Updated Document Type"))
        .andExpect(jsonPath("$.businessSegment").value("Updated Business Segment"));

    final String content = result.andReturn().getResponse().getContentAsString();
    final MemberResponse member = objectMapper.readValue(content, MemberResponse.class);

    assertNotEquals(member.getName(), "Member Name");
    assertNotEquals(member.getDocument(), "Document");
    assertNotEquals(member.getDocumentType(), "document Type");
    assertNotEquals(member.getBusinessSegment(), "Business Segment");

  }
}
