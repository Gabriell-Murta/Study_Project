package com.example.core.product.product;

import com.example.core.company.company.Company;
import com.example.core.member.member.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table
public class Product {

  @Id
  @SequenceGenerator(
      name = "product_sequence",
      sequenceName = "product_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "product_sequence"
  )
  private Long id;
  private String name;
  private String businessSegment;

  @JsonIgnore
  @OneToMany(mappedBy = "product")
  private Set<Member> members = new HashSet();

  @ManyToOne(cascade = CascadeType.ALL)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "company_id", referencedColumnName = "id")
  private Company company;

  public Product() {
  }

  public Product(String name, String businessSegment) {
    this.name = name;
    this.businessSegment = businessSegment;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBusinessSegment() {
    return businessSegment;
  }

  public void setBusinessSegment(String businessSegment) {
    this.businessSegment = businessSegment;
  }

  public Set<Member> getMembers() {
    return members;
  }

  public void setMembers(Set<Member> members) {
    this.members = members;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public void assignCompany(Company company) {
    this.company = company;
  }
}
