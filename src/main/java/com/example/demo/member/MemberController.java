package com.example.demo.member;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/member")
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

  @PutMapping("/{memberId}/product/{productId}")
  Member assignMemberToProduct(@PathVariable Long memberId, @PathVariable Long productId){
    return memberService.assignMemberToProduct(memberId,productId);
  }

}
