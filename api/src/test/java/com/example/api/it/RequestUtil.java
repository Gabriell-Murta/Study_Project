package com.example.api.it;

import com.example.api.company.model.CreateCompanyDTO;
import com.example.api.company.model.UpdateCompanyDTO;
import com.example.api.product.model.CreateProductDTO;
import com.example.api.product.model.UpdateProductDTO;

public class RequestUtil {

  public static CreateCompanyDTO createCompany(){
    return new CreateCompanyDTO("name", createProduct());
  }

  public static CreateProductDTO createProduct(){
    return new CreateProductDTO("name", "businessSegment");
  }

  public static UpdateCompanyDTO createUpdateCompanyDTO(){
    return new UpdateCompanyDTO("Updated Name");
  }

  public static UpdateProductDTO createUpdateProductDTO(){
    return new UpdateProductDTO("Updated Name", "Updated Business Segment");
  }

}
