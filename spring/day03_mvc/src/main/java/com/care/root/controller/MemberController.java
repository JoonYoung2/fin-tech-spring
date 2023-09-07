package com.care.root.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.dto.MemberDTO;
import com.care.root.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	@Autowired
	private HttpSession session;
	
	@GetMapping("member_index")
	public String index() {
		return "member/index";
	}
	
	@GetMapping("member_login")
	public String login() {
		return "member/login";
	}
	@GetMapping("member_register")
	public String register() {
		return "member/register";
	}
	@GetMapping("list")
	public String list(Model model) {
		ArrayList<MemberDTO> DB = service.getDb();
		model.addAttribute("member", DB);
		return "member/member_list";
	}
	
	@PostMapping("register.do")
	public String register(MemberDTO dto) {
		String msg = service.register(dto);
		if(msg.equals("성공")) {
			return "redirect:member_login";
		}
		return "redirect:member_register";
	}
	
	@PostMapping("login.do")
	public String login(MemberDTO dto, Model model) {
		String msg = service.login(dto);
		if(msg.equals("성공")) {
			return "redirect: member_index";
		}
		model.addAttribute("msg", msg);
		return "member/login";
	}
	
	@GetMapping("member_logout")
	public String logout() {
		session.invalidate();
		
		return "redirect: member_index";
	}
	
	@GetMapping("member_info")
	public String memberInfo(@RequestParam("id") String id, Model model) {
		MemberDTO dto = service.memberInfo(id);
		model.addAttribute("dto", dto);
		return "member/info";
	}
}
