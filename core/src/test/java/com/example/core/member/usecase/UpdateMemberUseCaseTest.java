package com.example.core.member.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.example.core.exceptions.BusinessException.Codes;
import com.example.core.exceptions.MemberNotFoundException;
import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import com.example.core.member.usecase.UpdateMemberUseCase.Request;
import com.example.core.product.product.Product;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateMemberUseCaseTest {

  @InjectMocks
  private UpdateMemberUseCase useCase;

  @Mock
  private MemberGateway memberGateway;

  private final Random rd = new Random();

  @Test
  void shouldThrowExceptionWhenProductIsNotFoundInDataBase(){
    when(memberGateway.existsMember(anyLong())).thenReturn(false);
    final Long id = rd.nextLong();
    final MemberNotFoundException exception = assertThrows(MemberNotFoundException.class, () -> useCase.execute(id, buildRequest()));
    assertEquals(Codes.MEMBER_NOT_FOUND_EXCEPTION.getCode(), exception.getCode());
    assertEquals("No Member found with provided ID - " + id, exception.getMessage());
  }

  @Test
  void shouldRunUseCaseAndReturn(){
    when(memberGateway.existsMember(anyLong())).thenReturn(true);
    when(memberGateway.findMemberById(anyLong())).thenReturn(buildMember());
    when(memberGateway.updateMember(any())).thenReturn(buildMember());

    final Member updatedMember = useCase.execute(anyLong(), buildRequest());
    assertNotNull(updatedMember);
  }

  private UpdateMemberUseCase.Request buildRequest(){
    final UpdateMemberUseCase.Request request = new Request("Test Member",
        "Test Member Document",
        "Test Member Document Type",
        "Test Member Business");
    return request;
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