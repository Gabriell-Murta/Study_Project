package com.example.core.company.company;

import com.example.core.product.product.Product;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Company {

  private Long id;
  private String name;
  private List<Product> products = new ArrayList<>();

  public Company(String name){
    this.name = name;
  }

}
