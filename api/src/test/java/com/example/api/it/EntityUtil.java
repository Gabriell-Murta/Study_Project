package com.example.api.it;

import com.example.data.company.entity.CompanyEntity;
import com.example.data.member.entity.MemberEntity;
import com.example.data.product.entity.ProductEntity;
import java.util.Random;

public class EntityUtil {

  private static final String COMPANY_NAME = "Company Name";
  private static final String PRODUCT_NAME = "Product Name";
  private static final String MEMBER_NAME = "Member Name";
  private static final String BUSINESS_SEGMENT = "Business Segment";
  private static final String DOCUMENT = "Document";
  private static final String DOCUMENT_TYPE = "Document Type";

  private static final Random rd = new Random();

  public static CompanyEntity createCompanyEntity(){
    final CompanyEntity entity = new CompanyEntity();
    entity.setId(rd.nextLong());
    entity.setName(COMPANY_NAME);
    return entity;
  }

  public static ProductEntity createProductEntity(final CompanyEntity company){
    final ProductEntity entity = new ProductEntity();
    entity.setId(rd.nextLong());
    entity.setName(PRODUCT_NAME);
    entity.setBusinessSegment(BUSINESS_SEGMENT);
    entity.setCompany(company);
    return entity;
  }

  public static MemberEntity createMemberEntity(final ProductEntity product){
    final MemberEntity entity = new MemberEntity();
    entity.setId(rd.nextLong());
    entity.setName(MEMBER_NAME);
    entity.setDocument(DOCUMENT);
    entity.setDocumentType(DOCUMENT_TYPE);
    entity.setBusinessSegment(BUSINESS_SEGMENT);
    entity.setProduct(product);
    return entity;
  }
}
