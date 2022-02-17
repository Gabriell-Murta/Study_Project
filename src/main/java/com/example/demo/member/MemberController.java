package com.example.demo.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/member")
public class MemberController {
    @GetMapping
    public String getMember(){
        return new Member("Gabriell").toString();
  }

}
