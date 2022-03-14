package com.example.core.member.gateway;

import com.example.core.member.member.Member;
import java.util.List;

public interface MemberGateway {

  List<Member> findMember();

  Member saveMember(Member member);

  void deleteMemberById(Long id);

  Member findMemberById(Long id);

}
