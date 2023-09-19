package com.care.root.member.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
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
		return "member/list";
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/login.do")
	public String login(MemberDTO dto, @RequestParam(required = false, defaultValue="off") String autoLogin, HttpSession session, HttpServletResponse res, Model model) {
		System.out.println(autoLogin);
		String msg = service.loginCheck(dto);
		if(!msg.equals("성공")) {
			model.addAttribute("msg", msg);
			model.addAttribute("autoLogin", autoLogin);
			return "member/login";
		}
		
		if(autoLogin.equals("on")) {
			int limitTime=60*60*24*90;
			Cookie loginCookie = new Cookie("loginCookie", session.getId());
			loginCookie.setPath("/");
			loginCookie.setMaxAge(limitTime);
			res.addCookie(loginCookie);
			
			service.keepLogin(session.getId(), dto.getId());
		}
		return "member/successLogin";
	}
	
	@GetMapping("/register")
	public String register() {
		return "member/register";
	}
	
	@PostMapping("/register.do")
	public String register(HttpServletRequest req, MemberDTO dto, Model model) {
		String[] addr = req.getParameterValues("addr");
		String addr2 = "";
		for(String ad : addr) {
			addr2 += ad + "/";
		}

		dto.setAddr(addr2);
		
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
	public String logout(@CookieValue(value="loginCookie", required = false) Cookie cookie, HttpServletResponse res) {
		if(cookie != null) {
			cookie.setMaxAge(0);
			res.addCookie(cookie);
			service.keepLogin("nan", (String)session.getAttribute("user_id"));
		}
		session.invalidate();
		return "redirect:/";
	}
}
