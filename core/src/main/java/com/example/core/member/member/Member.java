package com.example.core.member.member;

import com.example.core.product.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
public class Member {

  private Long id;
  private String name;
  private String document;
  private String documentType;
  private String businessSegment;
  private Product product;

  public Member(String name, String document, String documentType, String businessSegment) {
    this.name = name;
    this.document = document;
    this.documentType = documentType;
    this.businessSegment = businessSegment;
  }

  public Member(String name) {
    this.name = name;
  }
}
