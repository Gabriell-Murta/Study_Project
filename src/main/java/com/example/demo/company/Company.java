package com.example.demo.company;

import com.example.demo.product.Product;
import java.util.List;

public class Company {
    private Long id;
    private String name;
    private List<Product> products;

  public Company() {
  }

  public Company(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Company(Long id, String name, List<Product> products) {
    this.id = id;
    this.name = name;
    this.products = products;
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

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  @Override
  public String toString() {
    return "Company{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", products=" + products +
        '}';
  }
}
