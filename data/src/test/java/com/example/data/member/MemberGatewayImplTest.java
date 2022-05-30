package com.example.data.member;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.core.member.member.Member;
import com.example.data.member.entity.MemberEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MemberGatewayImplTest {

  @InjectMocks
  private MemberGatewayImpl gateway;

  @Mock
  private MemberRepository repository;

  private final Random rd = new Random();

  @Test
  void shouldListAllMembers(){
    when(repository.findAll()).thenReturn(buildMembersEntity());

    final List<Member> members = gateway.findMembers();
    assertEquals(members.size(), buildMembersEntity().size());
  }

  @Test
  void shouldGetMemberById(){
    when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(buildMemberEntity()));

    final Member member = gateway.findMemberById(rd.nextLong());
    assertEquals(buildMember().getName(), member.getName());
    assertEquals(buildMember().getBusinessSegment(), member.getBusinessSegment());
    assertEquals(buildMember().getDocument(), member.getDocument());
    assertEquals(buildMember().getDocumentType(), member.getDocumentType());
  }

  @Test
  void shouldAddMember(){
    when(repository.save(any())).thenReturn(buildMemberEntity());

    final Member member = gateway.saveMember(buildMember());
    assertEquals(buildMember().getName(), member.getName());
    assertEquals(buildMember().getBusinessSegment(), member.getBusinessSegment());
    assertEquals(buildMember().getDocument(), member.getDocument());
    assertEquals(buildMember().getDocumentType(), member.getDocumentType());
  }

  @Test
  void shouldDeleteMember(){
    final Long id = rd.nextLong();
    gateway.deleteMemberById(id);
    verify(repository, times(1)).deleteById(id);
  }

  @Test
  void shouldUpdateMember(){
    when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(buildMemberEntity()));
    when(repository.save(any())).thenReturn(buildMemberEntity());

    final Member member = gateway.updateMember(buildMember());
    assertNotNull(member);
  }

  @Test
  void shouldCheckIfMemberExist(){
    when(repository.existsById(anyLong())).thenReturn(true);

    boolean exists = gateway.existsMember(rd.nextLong());
    assertTrue(exists);
  }

  private List<MemberEntity> buildMembersEntity(){
    List<MemberEntity> members = new ArrayList<>();
    members.add(buildMemberEntity());
    members.add(buildMemberEntity());
    return members;
  }

  private MemberEntity buildMemberEntity(){
    return MemberEntity.builder()
        .id(rd.nextLong())
        .name("Test Member")
        .businessSegment("Test Member Business")
        .document("Test Member Document")
        .documentType("Test Member Document Type")
        .build();
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