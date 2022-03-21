package com.example.core.member.usecase;

import com.example.core.member.gateway.MemberGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DeleteMemberUseCase {

  private final MemberGateway memberGateway;

  public void execute(Long id){ memberGateway.deleteMemberById(id); }

}
