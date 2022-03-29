package com.example.core.member.usecase;

import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class GetMemberUseCase {

  private final MemberGateway memberGateway;

  public Member execute(Long id){
    return memberGateway.getMember(id);
  }

}