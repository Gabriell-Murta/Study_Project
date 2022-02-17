package com.example.demo.member;

public class Member {
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
        "name='" + name + '\'' +
        ", document='" + document + '\'' +
        ", documentType='" + documentType + '\'' +
        ", businessSegment='" + businessSegment + '\'' +
        '}';
  }
}
