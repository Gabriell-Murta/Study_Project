package com.example.core.product.product;

import com.example.core.company.company.Company;
import com.example.core.member.member.Member;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
public class Product {

  private Long id;
  private String name;
  private String businessSegment;
  private List<Member> members = new ArrayList<>();
  private Company company;

  public Product(String name, String businessSegment) {
    this.name = name;
    this.businessSegment = businessSegment;
  }

  public Product(String name, String businessSegment, Company company) {
    this.name = name;
    this.businessSegment = businessSegment;
    this.company =company;
  }

  public Product(String name) {
    this.name = name;
  }
}
