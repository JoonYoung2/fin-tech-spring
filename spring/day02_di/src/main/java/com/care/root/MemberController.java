package com.care.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	public MemberController() {
		System.out.println("memberController()");
	}
	
	@RequestMapping("/index")
	public String index() {
		System.out.println( ms );
		ms.test();
		return "index";
	}
}
