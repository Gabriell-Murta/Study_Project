package com.example.api.company.model;

import java.util.List;
import lombok.Data;

@Data
public class CompaniesResponse {

  public final List<CompanyResponse> companies;
}
