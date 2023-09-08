package com.care.root.member.service;

import java.util.List;

import com.care.root.member.dto.MemberDTO;

public interface MemberService {

	List<MemberDTO> getMemberList();

	String loginCheck(MemberDTO dto);

	String register(MemberDTO dto);

	MemberDTO getMemberInfo(String id);

}
