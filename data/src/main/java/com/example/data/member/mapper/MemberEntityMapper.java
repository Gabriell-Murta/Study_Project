package com.example.data.member.mapper;

import com.example.core.member.member.Member;
import com.example.data.member.entity.MemberEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.jpa.repository.JpaContext;

@Mapper(componentModel = "spring")
public interface MemberEntityMapper {

  MemberEntity toEntity(Member memberEntity, @Context JpaContext ctx);

  Member fromEntity(MemberEntity memberEntity, @Context JpaContext ctx);

}
