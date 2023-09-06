package com.care.root;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/index")
	public String memberIndex() {
		System.out.println("index 실행");
		return "member/index";
	}
}