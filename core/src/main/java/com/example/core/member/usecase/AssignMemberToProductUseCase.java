package com.example.core.member.usecase;

import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssignMemberToProductUseCase {

  private final MemberGateway memberGateway;
  private final ProductGateway productGateway;

  @Autowired
  public AssignMemberToProductUseCase(MemberGateway memberGateway,
      ProductGateway productGateway) {
    this.memberGateway = memberGateway;
    this.productGateway = productGateway;
  }

  public Member execute(Long memberId, Long productId){
    Member member = memberGateway.findMemberById(memberId);
    Product product = productGateway.findProductById(productId);

    member.assignProduct(product);
    return  memberGateway.saveMember(member);
  }
}
