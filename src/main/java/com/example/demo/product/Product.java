package com.example.demo.product;

import com.example.demo.member.Member;
import java.util.List;

public class Product {

  private String name;
  private List<Member> members;
  private String businessSegment;

  public Product() {
  }

  public Product(String name, String businessSegment) {
    this.name = name;
    this.businessSegment = businessSegment;
  }

  public Product(String name, List<Member> members, String businessSegment) {
    this.name = name;
    this.members = members;
    this.businessSegment = businessSegment;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Member> getMembers() {
    return members;
  }

  public void setMembers(List<Member> members) {
    this.members = members;
  }

  public String getBusinessSegment() {
    return businessSegment;
  }

  public void setBusinessSegment(String businessSegment) {
    this.businessSegment = businessSegment;
  }

  @Override
  public String toString() {
    return "Product{" +
        "name='" + name + '\'' +
        ", members=" + members +
        ", businessSegment='" + businessSegment + '\'' +
        '}';
  }
}

