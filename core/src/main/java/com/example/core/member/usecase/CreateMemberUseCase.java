package com.example.core.member.usecase;

import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import com.example.core.product.product.Product;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CreateMemberUseCase {

  private final MemberGateway memberGateway;

  @RequiredArgsConstructor
  public static class Request{

    private final String name;
    private final String document;
    private final String documentType;
    private final String businessSegment;

  }

  public Member execute(final Request request){

    final Member member = new Member(request.name, request.document, request.documentType, request.businessSegment);
    return memberGateway.saveMember(member);
  }
}
