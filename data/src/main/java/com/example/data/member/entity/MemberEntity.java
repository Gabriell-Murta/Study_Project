package com.example.data.member.entity;

import com.example.data.product.entity.ProductEntity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Entity(name = "Member")
@Table(name = "member")
public class MemberEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String document;
  private String documentType;
  private String businessSegment;

  @ManyToOne(fetch = FetchType.LAZY)
  @ToString.Exclude
  private ProductEntity product;
}
