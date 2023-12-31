package com.care.root.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private HttpSession session;
	
	BCryptPasswordEncoder encoder;
	
	public MemberServiceImpl() {
		encoder = new BCryptPasswordEncoder();
	}
	
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
			if(encoder.matches(dto.getPw(), check.getPw())) {
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
		String pw = dto.getPw();
		pw = encoder.encode(pw);
		dto.setPw(pw);
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

	public void keepLogin(String session_id, String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("session_id", session_id);
		map.put("id", id);
		mapper.keepLogin(map);
	}

	public MemberDTO getUserSessionId(String session_id) {
		
		return mapper.getUserSessionId(session_id);
	}
	
}
