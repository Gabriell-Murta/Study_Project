package com.example.core.member.member;

import com.example.core.product.product.Product;
import lombok.Data;

@Data
public class Member {

  private Long id;
  private String name;
  private String document;
  private String documentType;
  private String businessSegment;
  private Product product;

}
