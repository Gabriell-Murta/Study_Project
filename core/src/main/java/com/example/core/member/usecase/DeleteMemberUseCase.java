package com.example.core.member.usecase;

import com.example.core.exceptions.MemberNotFoundException;
import com.example.core.member.gateway.MemberGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DeleteMemberUseCase {

  private final MemberGateway memberGateway;

  public void execute(final Long id){

    if (!memberGateway.existsMember(id)){
      throw new MemberNotFoundException(id);
    }

    memberGateway.deleteMemberById(id);
  }

}
