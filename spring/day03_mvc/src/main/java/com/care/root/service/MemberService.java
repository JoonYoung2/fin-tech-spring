package com.care.root.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.dao.MemberDAO;
import com.care.root.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO dao;
	@Autowired
	private HttpSession session;
	
	public String register(MemberDTO dto) {
		ArrayList<MemberDTO> DB = dao.getDb();
		for(int i = 0; i < DB.size(); ++i) {
			MemberDTO check = new MemberDTO();
			check = DB.get(i);
			if(check.getId().equals(dto.getId())) {
				return "동일한 아이디가 있습니다.";
			}
		}
		dao.register(dto);
		return "성공";
	}

	public String login(MemberDTO dto) {
		ArrayList<MemberDTO> DB = dao.getDb();
		for(MemberDTO check : DB) {
			if(check.getId().equals(dto.getId())) {
				if(check.getPw().equals(dto.getPw())) {
					session.setAttribute("userId", dto.getId());
					return "성공";
				}else {
					return "비밀번호가 다릅니다.";
				}
			}
		}
		return "아이디가 없습니다.";
	}

	public ArrayList<MemberDTO> getDb() {
		return dao.getDb();
	}

	public MemberDTO memberInfo(String id) {
		ArrayList<MemberDTO> DB = dao.getDb();
		for(MemberDTO check : DB) {
			if(check.getId().equals(id)) {
				return check;
			}
		}
		return null;
	}
}
