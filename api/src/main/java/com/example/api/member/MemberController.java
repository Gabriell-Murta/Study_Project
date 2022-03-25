package com.example.api.member;

import com.example.api.member.model.CreateMemberDTO;
import com.example.api.member.model.UpdateMemberDTO;
import com.example.core.member.member.Member;
import com.example.core.member.usecase.AssignMemberToProductUseCase;
import com.example.core.member.usecase.CreateMemberUseCase;
import com.example.core.member.usecase.CreateMemberUseCase.Request;
import com.example.core.member.usecase.DeleteMemberUseCase;
import com.example.core.member.usecase.ListMembersUseCase;
import com.example.core.member.usecase.UpdateMemberUseCase;
import lombok.RequiredArgsConstructor;
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

  @GetMapping
  public List<Member> getMember(){
    return listMembersUseCase.execute();
  }

  @PostMapping("/{memberId}/product/{productId}")
  Member assignMemberToProduct(@PathVariable Long memberId, @PathVariable Long productId){
    return assignMemberToProductUseCase.execute(memberId,productId);
  }

  @PostMapping("/create")
  Member createMember(@RequestBody CreateMemberDTO dto){
    final CreateMemberUseCase.Request request = new Request(dto.getName(), dto.getDocument(), dto.getDocumentType(), dto.getBusinessSegment());
    return createMemberUseCase.execute(request);
  }

  @DeleteMapping("/delete/{id}")
  void deleteMember(@PathVariable Long id) {
    deleteMemberUseCase.execute(id);
  }

  @PostMapping("/update/{id}")
  Member updateMember(@PathVariable Long id, @RequestBody UpdateMemberDTO dto){
    final UpdateMemberUseCase.Request request = new UpdateMemberUseCase.Request(dto.getName());
    return updateMemberUseCase.execute(id, request);
  }

}
