package com.example.data.member.entity;

import com.example.data.product.entity.ProductEntity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "Member")
@Table(name = "member")
public class MemberEntity {

  @Id
  @SequenceGenerator(
      name = "member_sequence",
      sequenceName = "member_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "member_sequence"
  )
  private Long id;
  private String name;
  private String document;
  private String documentType;
  private String businessSegment;

  @ManyToOne(fetch = FetchType.LAZY)
  private ProductEntity product;
}
