package com.example.core.member.usecase;

import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AssignMemberToProductUseCase {

  private final MemberGateway memberGateway;
  private final ProductGateway productGateway;

  public Member execute(Long memberId, Long productId){
    Member member = memberGateway.findMemberById(memberId);
    Product product = productGateway.findProductById(productId);

    member.setProduct(product);
    return  memberGateway.saveMember(member);
  }
}
