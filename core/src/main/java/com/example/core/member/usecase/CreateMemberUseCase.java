package com.example.core.member.usecase;

import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateMemberUseCase {

  private final MemberGateway memberGateway;

  @Autowired
  public CreateMemberUseCase(MemberGateway memberGateway) {
    this.memberGateway = memberGateway;
  }

  public Member execute(Member member){ return memberGateway.saveMember(member); }
}
