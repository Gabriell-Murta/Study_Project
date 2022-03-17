package com.example.data.member;

import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MemberGatewayImpl implements MemberGateway {

  private final MemberRepository memberRepository;

  public MemberGatewayImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  @Transactional
  public List<Member> findMember() {

    return memberRepository.findAll();
  }

  @Override
  @Transactional
  public Member saveMember(Member member) {

    return memberRepository.save(member);
  }

  @Override
  @Transactional
  public void deleteMemberById(Long id) {

    memberRepository.deleteById(id);
  }

  @Override
  @Transactional
  public Member findMemberById(Long id) {

    if (memberRepository.existsById(id)){
      return memberRepository.findById(id).get();
    }

    return null;
  }
}
