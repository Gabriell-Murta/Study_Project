package com.example.core.member.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.core.exceptions.BusinessException.Codes;
import com.example.core.exceptions.MemberNotFoundException;
import com.example.core.member.gateway.MemberGateway;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DeleteMemberUseCaseTest {

  @InjectMocks
  private DeleteMemberUseCase useCase;

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
  void shouldDeleteMemberWithSuccess(){
    when(memberGateway.existsMember(anyLong())).thenReturn(true);
    useCase.execute(anyLong());

    verify(memberGateway, times(1)).deleteMemberById(anyLong());
  }

}