package com.care.root;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.config.TestClass;

@Controller
public class MailController {
	@Autowired
	private MailService service;
	@Autowired
	private TestClass testClass;
	
	@GetMapping("send_mail")
	public void sendMail(HttpServletResponse res) throws IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		service.send("jyseo0901@naver.com", "테스트 메일", "안녕하세용 반가워용");
		
		out.print("메일을 전송했습니다." + testClass.getName());
	}
	
	@GetMapping("send_mail2")
	public void sendMail2(HttpServletResponse res) throws IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		service.send2();
		
		out.print("메일을 전송했습니다." + testClass.getName());
	}
	
	@GetMapping("auth")
	public String authForm() {
		return "auth";
	}
	
	@PostMapping("auth_check")
	public String authCheck(HttpSession session, @RequestParam String email) {
		String[] e = email.split("@");
		System.out.println(e[0]);
		System.out.println(e[1]);
		
		service.send3(e[0], session, email);
		return "redirect:https://www."+e[1];
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:auth";
	}
	
	@GetMapping("check")
	public String userCheck(@RequestParam String user_id, @RequestParam String userKey, HttpSession session) {
		String userId = (String)session.getAttribute(user_id);
		if(userKey.equals(userId)) {
			System.out.println("인증성공!");
			session.setAttribute("user_id", user_id);
		}else {
			System.out.println("인증실패!");
		}
		return "redirect:auth";
	}
}
