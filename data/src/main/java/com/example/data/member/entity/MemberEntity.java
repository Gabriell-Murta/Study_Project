package com.example.data.member.entity;

import com.example.data.product.entity.ProductEntity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
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

  @ManyToOne(cascade = CascadeType.MERGE)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private ProductEntity product;
}
