package com.care.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController02 {
	@GetMapping("form")
	public String form() {
		return "login/form";
	}
	
	@PostMapping("login_chk")
	public String loginChke(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpSession session) {
		String DBId = "1", DBPwd = "1", nick = "홍길동";
		if(id.equals(DBId) && pwd.equals(DBPwd)) {
			session.setAttribute("id", DBId);
			session.setAttribute("nick", nick);
			return "redirect:main";
		}
		return "redirect:form";
	}
	
	@GetMapping("main")
	public String main(){
		return "login/main";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session, HttpServletRequest req) {
		HttpSession se02 = req.getSession();
		session.invalidate();
		return "redirect: form";
	}
}
