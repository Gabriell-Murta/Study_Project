package com.example.core.member.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.example.core.exceptions.BusinessException.Codes;
import com.example.core.exceptions.MemberNotFoundException;
import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetMemberUseCaseTest {

  @InjectMocks
  private GetMemberUseCase useCase;

  @Mock
  private MemberGateway memberGateway;

  private final Random rd = new Random();

  @Test
  void shouldThrowExceptionWhenProductIsNotFoundInDataBase(){
    when(memberGateway.existsMember(anyLong())).thenReturn(false);
    final Long id = rd.nextLong();
    final MemberNotFoundException exception = assertThrows(MemberNotFoundException.class, () -> useCase.execute(id));
    assertEquals(Codes.MEMBER_NOT_FOUND_EXCEPTION.getCode(), exception.getCode());
    assertEquals("No Member found with provided ID - " + id, exception.getMessage());
  }

  @Test
  void shouldExecuteUseCaseAndReturnMember(){
    when(memberGateway.existsMember(anyLong())).thenReturn(true);
    when(memberGateway.getMember(anyLong())).thenReturn(buildMember());

    final Member memberAfterUseCase = useCase.execute(anyLong());
    assertEquals(buildMember().getName(), memberAfterUseCase.getName());
    assertEquals(buildMember().getBusinessSegment(), memberAfterUseCase.getBusinessSegment());
    assertEquals(buildMember().getDocument(), memberAfterUseCase.getDocument());
    assertEquals(buildMember().getDocumentType(), memberAfterUseCase.getDocumentType());
  }

  private Member buildMember(){
    return Member.builder()
        .id(rd.nextLong())
        .name("Test Member")
        .businessSegment("Test Member Business")
        .document("Test Member Document")
        .documentType("Test Member Document Type")
        .build();
  }

}