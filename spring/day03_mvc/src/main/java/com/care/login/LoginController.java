package com.care.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("red")
public class LoginController {
	
	@GetMapping("index")
	public String index() {
		return "test/index";
	}
	
	@PostMapping("login_chk")
	public String loginChk(@RequestParam("id") String id, @RequestParam("pwd") String pwd, RedirectAttributes ra) {
		System.out.println("id : " + id);
		System.out.println("pwd : " + pwd);
		
		String DBId = "1", DBPwd = "1";
		if(id.equals(DBId) && pwd.equals(DBPwd)) {
			TestDTO dto = new TestDTO();
			dto.setId("aaa");
			dto.setPwd("111");
			dto.setName("홍길동");
			ra.addFlashAttribute(dto);
			return "redirect:main03";
		}
		return "redirect:index";
	}
	
	@GetMapping("main")
	public String main() {
		System.out.println("로그인 성공");
		
		return null;
	}
	
	@GetMapping("main03")
	public String main02 ( TestDTO d ) {
		System.out.println("로그인 성공03 => " + d.getId());
		System.out.println("로그인 성공03 => " + d.getPwd());
		System.out.println("로그인 성공03 => " + d.getName());
		return null;
	}
	
	@GetMapping("main02")
	public String main02(@RequestParam String id) {
		System.out.println("로그인 성공02 => " + id);
		return null;
	}
	
	@GetMapping("main01")
	public String main01(@RequestParam String id) {
		System.out.println("로그인 성공01 => " + id);
		return null;
	}
}
