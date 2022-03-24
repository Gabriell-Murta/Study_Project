package com.example.data.company.entity;

import com.example.core.product.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "company")
public class CompanyEntity {
  @Id
  @SequenceGenerator(
      name = "company_sequence",
      sequenceName = "company_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "company_sequence"
  )
  private Long id;
  private String name;

  @JsonIgnore
  @OneToMany(mappedBy = "company")
  private Set<Product> products = new HashSet();

}
