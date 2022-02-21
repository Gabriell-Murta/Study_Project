package com.example.demo.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

  public Member() {
  }

  public Member(String name) {
    this.name = name;
  }

  public Member(String name, String document, String documentType, String businessSegment) {
    this.name = name;
    this.document = document;
    this.documentType = documentType;
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

  @Override
  public String toString() {
    return "Member{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", document='" + document + '\'' +
        ", documentType='" + documentType + '\'' +
        ", businessSegment='" + businessSegment + '\'' +
        '}';
  }
}