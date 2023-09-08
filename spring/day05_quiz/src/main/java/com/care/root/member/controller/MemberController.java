package com.care.root.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	@Autowired
	private HttpSession session;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/info")
	public String info(Model model) {
		List<MemberDTO> dto = service.getMemberList();
		model.addAttribute("member", dto);
		return "member/info";
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/login.do")
	public String login(MemberDTO dto, Model model) {
		String msg = service.loginCheck(dto);
		if(!msg.equals("성공")) {
			model.addAttribute("msg", msg);
			return "member/login";
		}
		return "member/successLogin";
	}
	
	@GetMapping("/register")
	public String register() {
		return "member/register";
	}
	
	@PostMapping("/register.do")
	public String register(MemberDTO dto, Model model) {
		String msg = service.register(dto);
		
		if(!msg.equals("성공")) {
			model.addAttribute("msg", msg);
			return "member/register";
		}
		return "redirect:login";
	}
	
	@GetMapping("/member_info")
	public String memberInfo(@RequestParam("id") String id, Model model) {
		MemberDTO member = service.getMemberInfo(id);
		model.addAttribute("member", member);
		return "member/memberInfo";
	}
	
	@GetMapping("logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
}
