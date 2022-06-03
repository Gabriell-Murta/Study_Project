package com.example.api.it;

import com.example.api.company.model.CreateCompanyDTO;
import com.example.api.product.model.CreateProductDTO;

public class RequestUtil {

  public static CreateCompanyDTO createCompany(){
    return new CreateCompanyDTO("name", createProduct());
  }

  public static CreateProductDTO createProduct(){
    return new CreateProductDTO("name", "businessSegment");
  }

}
