package com.example.core.product.product;

import com.example.core.company.company.Company;
import com.example.core.member.member.Member;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
public class Product {

  private Long id;
  private String name;
  private String businessSegment;
  private Set<Member> members = new HashSet();
  private Company company;

}
