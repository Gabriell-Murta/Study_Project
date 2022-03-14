package com.example.api.member;

import com.example.core.member.member.Member;
import com.example.core.member.usecase.MemberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v2/member")
public class MemberController {

  private final MemberService memberService;

  @Autowired
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping
  public List<Member> getMember(){
    return memberService.getMember();
  }

  @PostMapping("/{memberId}/product/{productId}")
  Member assignMemberToProduct(@PathVariable Long memberId, @PathVariable Long productId){
    return memberService.assignMemberToProduct(memberId,productId);
  }

  @PostMapping("/create")
  Member createMember(@RequestBody Member member){
    return memberService.createMember(member);
  }

  @DeleteMapping("/delete/{id}")
  void deleteMember(@PathVariable Long id) {
    memberService.deleteMember(id);
  }

  @PostMapping("/update/{id}")
  Member updateMember(@PathVariable Long id, @RequestBody Member member){
    return memberService.updateMember(id, member);
  }

}
