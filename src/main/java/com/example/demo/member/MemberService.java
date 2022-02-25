package com.example.demo.member;

import com.example.demo.product.Product;
import com.example.demo.product.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

  private final MemberRepository memberRepository;
  private final ProductRepository productRepository;

  @Autowired
  public MemberService(MemberRepository memberRepository,
      ProductRepository productRepository) {
    this.memberRepository = memberRepository;
    this.productRepository = productRepository;
  }

  public List<Member> getMember(){
    return memberRepository.findAll();
  }

  public Member assignMemberToProduct(Long memberId, Long productId) {
    Member member = memberRepository.findById(memberId).get();
    Product product = productRepository.findById(productId).get();
    member.assignProduct(product);
    return memberRepository.save(member);
  }

  public Member createMember(Member member) {
    return memberRepository.save(member);
  }

  public void deleteMember(Long id) {
    memberRepository.deleteById(id);
  }

  public Member updateMember(Long id, Member memberUpdate) {
    Member member = memberRepository.findById(id).get();

    if(memberUpdate.getName() != null && !memberUpdate.getName().isEmpty()){
      member.setName(memberUpdate.getName());
    }

    if(memberUpdate.getBusinessSegment() != null && !memberUpdate.getBusinessSegment().isEmpty()){
      member.setBusinessSegment(memberUpdate.getBusinessSegment());
    }

    memberRepository.save(member);
    return member;
  }
}
