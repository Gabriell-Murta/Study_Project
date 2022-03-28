package com.example.api.product.model;

import com.example.api.company.model.CreateCompanyDTO;
import com.example.api.member.model.CreateMemberDTO;
import lombok.Data;

@Data
public class CreateProductDTO {

  private String name;
  private String businessSegment;
  private CreateCompanyDTO company;
  private CreateMemberDTO member;
}
