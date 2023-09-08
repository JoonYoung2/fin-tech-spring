package com.care.root.member.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private HttpSession session;
	
	public List<MemberDTO> getMemberList() {
		return mapper.getMemberList();
	}

	public String loginCheck(MemberDTO dto) {
		MemberDTO check = mapper.getUserById(dto.getId());
		String msg = "";
		if(check == null) {
			return "없는 아이디입니다.";
		}
		if(check.getId().equals(dto.getId())) {
			if(check.getPw().equals(dto.getPw())) {
				session.setAttribute("user_id", dto.getId());
				msg = "성공";
			}else {
				msg = "비밀번호가 일치하지 않습니다.";
			}
		}else {
			msg = "없는 아이디입니다.";
		}
		return msg;
	}

	public String register(MemberDTO dto) {
		String msg = "";
		int result = 0;
		try {
			result = mapper.register(dto);			
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(result == 1) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		return msg;
	}

	public MemberDTO getMemberInfo(String id) {
		
		return mapper.getUserById(id);
	}
	
}
