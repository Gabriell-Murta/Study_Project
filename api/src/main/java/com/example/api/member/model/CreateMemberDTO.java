package com.example.api.member.model;

import com.example.api.product.model.CreateProductDTO;
import lombok.Data;

@Data
public class CreateMemberDTO {

  private String name;
  private String document;
  private String documentType;
  private String businessSegment;
  private CreateProductDTO product;

}
