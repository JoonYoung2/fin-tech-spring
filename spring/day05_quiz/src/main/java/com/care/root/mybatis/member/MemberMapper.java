package com.care.root.mybatis.member;

import java.util.List;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {

	public List<MemberDTO> getMemberList();

	public MemberDTO getUserById(String id);

	public int register(MemberDTO dto);
}
