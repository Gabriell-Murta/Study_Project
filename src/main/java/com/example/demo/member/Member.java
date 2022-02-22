package com.example.demo.member;

import com.example.demo.product.Product;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Member {

  @Id
  @SequenceGenerator(
      name = "member_sequence",
      sequenceName = "member_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "member_sequence"
  )
  private Long id;
  private String name;
  private String document;
  private String documentType;
  private String businessSegment;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product product;

  public Member() {
  }

  public Member(String name) {
    this.name = name;
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

  public String getDocument() {
    return document;
  }

  public void setDocument(String document) {
    this.document = document;
  }

  public String getDocumentType() {
    return documentType;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  public String getBusinessSegment() {
    return businessSegment;
  }

  public void setBusinessSegment(String businessSegment) {
    this.businessSegment = businessSegment;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public void assignProduct(Product product) {
    this.product = product;
  }
}