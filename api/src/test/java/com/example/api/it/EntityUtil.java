package com.example.api.it;

import com.example.data.company.entity.CompanyEntity;
import java.util.Random;

public class EntityUtil {

  private static final String COMPANY_NAME = "Company Name";

  private static final Random rd = new Random();

  public static CompanyEntity createCompanyEntity(){
    final CompanyEntity entity = new CompanyEntity();
    entity.setId(rd.nextLong());
    entity.setName(COMPANY_NAME);
    return entity;
  }
}
