package com.example.core.member.usecase;

import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ListMembersUseCase {

  private final MemberGateway memberGateway;

  public List<Member> execute() { return memberGateway.findMember(); }

}
