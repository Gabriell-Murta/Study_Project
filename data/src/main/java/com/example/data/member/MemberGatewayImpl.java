package com.example.data.member;

import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import com.example.data.member.entity.MemberEntity;
import com.example.data.member.mapper.MemberEntityMapper;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberGatewayImpl implements MemberGateway {

  private final JpaContext jpaContext;
  private final MemberRepository memberRepository;
  private final MemberEntityMapper memberEntityMapper = Mappers.getMapper(MemberEntityMapper.class);

  @Override
  @Transactional
  public List<Member> findMembers() {
    final List<MemberEntity> memberEntities = memberRepository.findAll();
    return memberEntities.stream().map(Member -> memberEntityMapper.fromEntity(Member, jpaContext)).collect(Collectors.toList());
  }

  @Override
  @Transactional
  public Member getMember(Long id){

    final MemberEntity memberEntity = memberRepository.findById(id).get();
    return memberEntityMapper.fromEntity(memberEntity, jpaContext);
  }

  @Override
  @Transactional
  public Member saveMember(Member member) {

    final MemberEntity memberEntity = memberEntityMapper.toEntity(member, jpaContext);
    return memberEntityMapper.fromEntity(memberRepository.save(memberEntity), jpaContext);
  }

  @Override
  @Transactional
  public void deleteMemberById(Long id) {

    memberRepository.deleteById(id);
  }

  @Override
  @Transactional
  public Member findMemberById(Long id) {

    final MemberEntity memberEntity = memberRepository.findById(id).get();
    return memberEntityMapper.fromEntity(memberEntity, jpaContext);
  }
}
