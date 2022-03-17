package com.example.core.member.usecase;

import com.example.core.member.gateway.MemberGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteMemberUseCase {

  private final MemberGateway memberGateway;

  @Autowired
  public DeleteMemberUseCase(MemberGateway memberGateway) {
    this.memberGateway = memberGateway;
  }

  public void execute(Long id){ memberGateway.deleteMemberById(id); }

}
