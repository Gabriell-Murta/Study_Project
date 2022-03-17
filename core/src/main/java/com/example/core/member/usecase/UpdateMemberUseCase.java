package com.example.core.member.usecase;

import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateMemberUseCase {

  private final MemberGateway memberGateway;

  @Autowired
  public UpdateMemberUseCase(MemberGateway memberGateway) {
    this.memberGateway = memberGateway;
  }

  public Member execute(Long id, Member memberUpdate){
    Member member = memberGateway.findMemberById(id);

    if (memberUpdate.getName() != null && !memberUpdate.getName().isEmpty()){
      member.setName(memberUpdate.getName());
    }

    memberGateway.saveMember(member);
    return member;
  }
}
