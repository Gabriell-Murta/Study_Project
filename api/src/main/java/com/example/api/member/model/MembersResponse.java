package com.example.api.member.model;

import java.util.List;
import lombok.Data;

@Data
public class MembersResponse {

  public final List<MemberResponse> members;

}
