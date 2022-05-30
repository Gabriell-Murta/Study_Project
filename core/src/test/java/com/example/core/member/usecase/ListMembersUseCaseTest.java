package com.example.core.member.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ListMembersUseCaseTest {

  @InjectMocks
  private ListMembersUseCase useCase;

  @Mock
  private MemberGateway memberGateway;

  private final Random rd = new Random();

  @Test
  void shouldListAllMembers(){
    when(memberGateway.findMembers()).thenReturn(buildMembers());

    final List<Member> members = useCase.execute();
    assertEquals(members.size(), buildMembers().size());
  }

  private List<Member> buildMembers(){
    List<Member> members = new ArrayList<>();
    members.add(buildMember());
    members.add(buildMember());
    return members;
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