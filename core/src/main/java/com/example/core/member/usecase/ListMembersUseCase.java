package com.example.core.member.usecase;

import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListMembersUseCase {

  private final MemberGateway memberGateway;

  @Autowired
  public ListMembersUseCase(MemberGateway memberGateway) {
    this.memberGateway = memberGateway;
  }

  public List<Member> execute() { return memberGateway.findMember(); }

}
