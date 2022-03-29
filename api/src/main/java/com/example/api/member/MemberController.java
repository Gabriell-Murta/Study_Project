package com.example.api.member;

import com.example.api.member.model.CreateMemberDTO;
import com.example.api.member.model.MemberResponse;
import com.example.api.member.model.MembersResponse;
import com.example.api.member.model.UpdateMemberDTO;
import com.example.api.member.mapper.MemberResponseMapper;
import com.example.core.member.member.Member;
import com.example.core.member.usecase.AssignMemberToProductUseCase;
import com.example.core.member.usecase.CreateMemberUseCase;
import com.example.core.member.usecase.CreateMemberUseCase.Request;
import com.example.core.member.usecase.DeleteMemberUseCase;
import com.example.core.member.usecase.ListMembersUseCase;
import com.example.core.member.usecase.UpdateMemberUseCase;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v2/member")
@RequiredArgsConstructor
public class MemberController {

  private final AssignMemberToProductUseCase assignMemberToProductUseCase;
  private final CreateMemberUseCase createMemberUseCase;
  private final DeleteMemberUseCase deleteMemberUseCase;
  private final ListMembersUseCase listMembersUseCase;
  private final UpdateMemberUseCase updateMemberUseCase;
  private final MemberResponseMapper mapper = Mappers.getMapper(MemberResponseMapper.class);

  @GetMapping
  public ResponseEntity<MembersResponse> getMember(){
    final List<Member> members = listMembersUseCase.execute();
    final List<MemberResponse> responses = members.stream().map(mapper::toResponse).collect(Collectors.toList());
    return ResponseEntity.ok().body(new MembersResponse(responses));
  }

  @PostMapping("/{memberId}/product/{productId}")
  public ResponseEntity<MemberResponse> assignMemberToProduct(@PathVariable Long memberId, @PathVariable Long productId){
    final Member member = assignMemberToProductUseCase.execute(memberId,productId);
    return ResponseEntity.ok(mapper.toResponse(member));
  }

  @PostMapping("/create")
  public ResponseEntity<MemberResponse> createMember(@RequestBody CreateMemberDTO dto){
    final CreateMemberUseCase.Request request = new Request(dto.getName(), dto.getDocument(), dto.getDocumentType(), dto.getBusinessSegment());
    final Member member = createMemberUseCase.execute(request);
    return ResponseEntity.ok(mapper.toResponse(member));
  }

  @DeleteMapping("/delete/{id}")
  void deleteMember(@PathVariable Long id) {
    deleteMemberUseCase.execute(id);
  }

  @PostMapping("/update/{id}")
  public ResponseEntity<MemberResponse> updateMember(@PathVariable Long id, @RequestBody UpdateMemberDTO dto){
    final UpdateMemberUseCase.Request request = new UpdateMemberUseCase.Request(dto.getName());
    final Member member = updateMemberUseCase.execute(id, request);
    return ResponseEntity.ok(mapper.toResponse(member));
  }

}
