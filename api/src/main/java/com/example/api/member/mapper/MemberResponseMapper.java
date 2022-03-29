package com.example.api.member.mapper;

import com.example.api.member.model.MemberResponse;
import com.example.core.member.member.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberResponseMapper {

  MemberResponse toResponse(Member member);

}
