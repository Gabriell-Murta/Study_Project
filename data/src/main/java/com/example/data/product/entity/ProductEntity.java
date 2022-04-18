package com.example.data.product.entity;

import com.example.data.company.entity.CompanyEntity;
import com.example.data.member.entity.MemberEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity(name = "Product")
@Table(name = "product")
public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String businessSegment;

  @OneToMany(mappedBy = "product")
  private Set<MemberEntity> members = new HashSet();

  @ManyToOne(fetch = FetchType.LAZY)
  private CompanyEntity company;

}
