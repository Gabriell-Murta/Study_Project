package com.example.data.company.entity;

import com.example.data.product.entity.ProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity(name = "Company")
@Table(name = "company")
public class CompanyEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @OneToMany(mappedBy = "company",
  cascade = CascadeType.ALL,
  orphanRemoval = true)
  @ToString.Exclude
  private List<ProductEntity> products = new ArrayList<>();

}
