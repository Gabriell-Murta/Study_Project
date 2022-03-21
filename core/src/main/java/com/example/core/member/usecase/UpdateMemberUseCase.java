package com.example.core.member.usecase;

import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UpdateMemberUseCase {

  private final MemberGateway memberGateway;

  public Member execute(Long id, Member memberUpdate){
    Member member = memberGateway.findMemberById(id);

    if (memberUpdate.getName() != null && !memberUpdate.getName().isEmpty()){
      member.setName(memberUpdate.getName());
    }

    memberGateway.saveMember(member);
    return member;
  }
}
