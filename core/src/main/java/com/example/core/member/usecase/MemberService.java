package com.example.core.member.usecase;

import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

  private final MemberGateway memberGateway;
  private final ProductGateway productGateway;

  @Autowired
  public MemberService(MemberGateway memberGateway,
      ProductGateway productGateway) {
    this.memberGateway = memberGateway;
    this.productGateway = productGateway;
  }

  public List<Member> getMember(){
    return memberGateway.findMember();
  }

  public Member assignMemberToProduct(Long memberId, Long productId) {
    Member member = memberGateway.findMemberById(memberId);
    Product product = productGateway.findProductById(productId);
    member.assignProduct(product);
    return memberGateway.saveMember(member);
  }

  public Member createMember(Member member) {
    return memberGateway.saveMember(member);
  }

  public void deleteMember(Long id) {
    memberGateway.deleteMemberById(id);
  }

  public Member updateMember(Long id, Member memberUpdate) {
    Member member = memberGateway.findMemberById(id);

    if(memberUpdate.getName() != null && !memberUpdate.getName().isEmpty()){
      member.setName(memberUpdate.getName());
    }

    if(memberUpdate.getBusinessSegment() != null && !memberUpdate.getBusinessSegment().isEmpty()){
      member.setBusinessSegment(memberUpdate.getBusinessSegment());
    }

    memberGateway.saveMember(member);
    return member;
  }
}
