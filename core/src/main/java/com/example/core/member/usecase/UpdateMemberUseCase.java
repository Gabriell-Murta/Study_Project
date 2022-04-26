package com.example.core.member.usecase;

import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import com.example.core.utils.ValidationHelper;
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
    private final String document;
    private final String documentType;
    private final String businessSegment;
  }

  public Member execute(final Long id, final Request request){
    Member member = memberGateway.findMemberById(id);
    final Member memberUpdate = new Member(request.name, request.document, request.documentType,
        request.businessSegment);

    if (ValidationHelper.fieldHasValidValue(memberUpdate.getName())){
      member.setName(memberUpdate.getName());
    }

    if (ValidationHelper.fieldHasValidValue(memberUpdate.getDocument())){
      member.setDocument(memberUpdate.getDocument());
    }

    if (ValidationHelper.fieldHasValidValue(memberUpdate.getDocumentType())){
      member.setDocumentType(memberUpdate.getDocumentType());
    }

    if (ValidationHelper.fieldHasValidValue(memberUpdate.getBusinessSegment())){
      member.setBusinessSegment(memberUpdate.getBusinessSegment());
    }

    memberGateway.updateMember(member);
    return member;
  }
}
