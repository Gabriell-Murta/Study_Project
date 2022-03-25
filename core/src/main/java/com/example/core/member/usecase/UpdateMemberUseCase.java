package com.example.core.member.usecase;

import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UpdateMemberUseCase {

  private final MemberGateway memberGateway;

  @RequiredArgsConstructor
  public static class Request{

    private final String name;

  }

  public Member execute(Long id, Request request){
    Member member = memberGateway.findMemberById(id);
    Member memberUpdate = new Member(request.name);

    if (memberUpdate.getName() != null && !memberUpdate.getName().isEmpty()){
      member.setName(memberUpdate.getName());
    }

    memberGateway.saveMember(member);
    return member;
  }
}
