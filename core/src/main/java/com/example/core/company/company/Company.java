package com.example.core.company.company;

import com.example.core.product.product.Product;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
public class Company {

  private Long id;
  private String name;
  private Set<Product> products = new HashSet();

}
