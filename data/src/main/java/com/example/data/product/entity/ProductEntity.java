package com.example.data.product.entity;

import com.example.data.company.entity.CompanyEntity;
import com.example.data.member.entity.MemberEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity(name = "Product")
@Table(name = "product")
public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String businessSegment;

  @OneToMany(mappedBy = "product",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  @ToString.Exclude
  private List<MemberEntity> members = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @ToString.Exclude
  private CompanyEntity company;

}
