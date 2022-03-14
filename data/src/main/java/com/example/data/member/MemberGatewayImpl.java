package com.example.data.member;

import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import java.util.List;

public class MemberGatewayImpl implements MemberGateway {

  private final MemberRepository memberRepository;

  public MemberGatewayImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  public List<Member> findMember() {

    return memberRepository.findAll();
  }

  @Override
  public Member saveMember(Member member) {

    return memberRepository.save(member);
  }

  @Override
  public void deleteMemberById(Long id) {

    memberRepository.deleteById(id);
  }

  @Override
  public Member findMemberById(Long id) {

    if (memberRepository.existsById(id)){
      return memberRepository.findById(id).get();
    }

    return null;
  }
}
